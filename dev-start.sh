#!/bin/bash

# Development script for Leave Application Processing System
# This script helps with development by watching CSS changes and starting the Spring Boot application

echo "🚀 Starting Leave Application Processing System Development Environment"
echo ""

# Function to cleanup background processes
cleanup() {
    echo ""
    echo "🛑 Shutting down development environment..."
    pkill -f "tailwindcss.*--watch" 2>/dev/null
    pkill -f "mvn spring-boot:run" 2>/dev/null
    exit 0
}

# Set up signal handler for clean shutdown
trap cleanup SIGINT SIGTERM

# Start Tailwind CSS in watch mode
echo "📦 Starting Tailwind CSS watcher..."
npm run watch-css &
TAILWIND_PID=$!

# Give Tailwind a moment to start
sleep 2

echo "🌱 Starting Spring Boot application..."
echo "   Access the application at: http://localhost:8080"
echo "   Press Ctrl+C to stop all services"
echo ""

# Start Spring Boot application
mvn spring-boot:run

# If Spring Boot exits, cleanup
cleanup
