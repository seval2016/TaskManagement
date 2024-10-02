package com.seval.service;

import com.seval.config.JwtProvider;
import com.seval.modal.User;
import com.seval.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements  UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserProfile(String jwt) {
        return userRepository.findByEmail(JwtProvider.getEmailFromJwtToken(jwt));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
