package com.seval.service;

import com.seval.modal.User;

import java.util.List;

public interface UserService {

    public User getUserProfile(String jwt);

    public List<User> getAllUsers();
}
