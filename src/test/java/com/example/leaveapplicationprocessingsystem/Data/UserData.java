package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserData {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserData() {
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Fiona", "George", "Hannah", "Ian", "Julia"};
        String[] lastNames = {"Johnson", "Smith", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};

        for (int i = 0; i < 10; i++) {
            String email = firstNames[i].toLowerCase() + "." + lastNames[i].toLowerCase() + "@example.com";
            String username = firstNames[i].toLowerCase() + lastNames[i].toLowerCase();
            String firstName = firstNames[i];
            String lastName = lastNames[i];
            String password = "password";
            int roleId = (i % 3) + 1;

            User user = new User(email, firstName, lastName, username, password, roleId);
            userRepository.save(user);
        }
    }
}
