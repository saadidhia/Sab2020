package com.authgoogle.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.authgoogle.model.Role;

/**
 * Created by dhia on 15/03/20.
 */

public class SignUpRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getName() {
        return name;
    }
    
    
    private Role role;

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Role getRole() {
		// TODO Auto-generated method stub
		return role;
	}
}
