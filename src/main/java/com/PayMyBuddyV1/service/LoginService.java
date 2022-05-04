package com.PayMyBuddyV1.service;

import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository ;

    public User login(String email, String password){
        User user = userRepository.findByEmailAndPassword( email )
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        return user;
    }
}
