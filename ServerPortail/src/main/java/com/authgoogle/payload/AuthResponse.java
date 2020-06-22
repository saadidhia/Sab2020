package com.authgoogle.payload;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserDetails user; 
    private String message;
    public AuthResponse(String accessToken, UserDetails details) {
        this.accessToken = accessToken;
        user = details; 
    }

    public AuthResponse(String Message){
        this.message = Message;
    }

    public String getMessage(){
        return this.message;
    }

    public UserDetails getUser(){
        return user; 
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
