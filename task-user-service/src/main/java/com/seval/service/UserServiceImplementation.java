package com.seval.service;

import com.seval.config.JwtProvider;
import com.seval.modal.User;
import com.seval.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserProfile(String jwt) {

        return userRepository.findByEmail(JwtProvider.getEmailFromJwtToken(jwt));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
