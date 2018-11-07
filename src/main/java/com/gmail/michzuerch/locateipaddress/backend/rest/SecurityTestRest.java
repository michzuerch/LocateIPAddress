package com.gmail.michzuerch.locateipaddress.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestRest {

    @Autowired
    private UserDetailsService userService;

    @GetMapping("/api")
    public String greeting(Authentication authentication) {
        return "Spring Security In-memory Authentication Example";
    }

}