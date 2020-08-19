package com.evgkor.finalProject.service;

import com.evgkor.finalProject.bean.User;
import com.evgkor.finalProject.config.MyUserDetails;
import com.evgkor.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepository.getUserByUsername(username);
       if(user==null){
           throw new UsernameNotFoundException("Could not find this user");
       }
       return new MyUserDetails(user);
    }
}
