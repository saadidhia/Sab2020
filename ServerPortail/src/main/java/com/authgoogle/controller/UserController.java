package com.authgoogle.controller;

import com.authgoogle.*;
import com.authgoogle.exception.ResourceNotFoundException;
import com.authgoogle.model.User;
import com.authgoogle.repository.UserRepository;
import com.authgoogle.security.CurrentUser;
import com.authgoogle.security.UserPrincipal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collaborateurs")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getUid())
                .orElseThrow(() -> new ResourceNotFoundException("User", "uid", userPrincipal.getUid()));
    }
    
   /* @GetMapping("they")
    @Secured("ROLE_USER")
    public String getthem() {
    	   SecurityContext securityContext = SecurityContextHolder.getContext();
    	    return securityContext.getAuthentication().getName();
    	
    }*/
    
    @GetMapping("all")
  //  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getCollaborateurs (){
    	return userRepository.findAll();
    }
   
    
    
}
