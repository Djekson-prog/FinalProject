package com.evgkor.finalProject.service;

import com.evgkor.finalProject.bean.Role;
import com.evgkor.finalProject.bean.User;
import com.evgkor.finalProject.repository.RoleRepository;
import com.evgkor.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleRepository roleRepository;

    private static final String USER_ROLE = "USER";

    public boolean saveUser(User user) {

        User userFromDB = userRepository.getUserByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(roleRepository.findByRole(USER_ROLE)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
        return true;
    }
}
