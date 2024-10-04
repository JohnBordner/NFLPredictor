

package com.johnbordner.NFLhypoBet.service;

import com.johnbordner.NFLhypoBet.model.User;
import com.johnbordner.NFLhypoBet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerUser(String username, String rawPassword) {
        // Check if username already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        return userRepository.save(user);


    }





    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }




}
