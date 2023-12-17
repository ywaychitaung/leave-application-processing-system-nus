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
        User user1 = new User("ywaychitaung@gmail.com", "ywaychitaung", "123456", 1);

        userRepository.save(user1);
    }
}
