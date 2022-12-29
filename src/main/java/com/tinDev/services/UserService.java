package com.tinDev.services;

import com.tinDev.models.user.User;
import com.tinDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

//    public User getById(String id) {
//        return userRepository.getById(id);
//    }
}
