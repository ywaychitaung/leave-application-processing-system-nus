# Build stage for Node.js
FROM node:18-alpine AS node-builder
WORKDIR /app
COPY package*.json ./
COPY tailwind.config.js ./
COPY src/main/resources/static/tailwind.css ./src/main/resources/static/
COPY src/main/resources/templates ./src/main/resources/templates
RUN apk add --no-cache bash
RUN npm install --production=false
RUN mkdir -p src/main/resources/static
RUN npm run build

# Build stage for Maven
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
COPY --from=node-builder /app/src/main/resources/static/style.css ./src/main/resources/static/
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Create .env file from environment variables
RUN echo "DB_HOST=\${DB_HOST}\n\
DB_PORT=\${DB_PORT}\n\
DB_NAME=\${DB_NAME}\n\
DB_USER=\${DB_USER}\n\
DB_PASSWORD=\${DB_PASSWORD}" > .env

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]