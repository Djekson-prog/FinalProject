package com.evgkor.finalProject.service;

import com.evgkor.finalProject.bean.User;
import com.evgkor.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
