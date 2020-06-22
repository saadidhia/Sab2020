package com.authgoogle.controller;

import com.authgoogle.*;
import com.authgoogle.exception.ResourceNotFoundException;
import com.authgoogle.model.User;
import com.authgoogle.repository.UserRepository;
import com.authgoogle.security.CurrentUser;
import com.authgoogle.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getUid())
                .orElseThrow(() -> new ResourceNotFoundException("User", "uid", userPrincipal.getUid()));
    }
    
    
}
