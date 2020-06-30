package com.authgoogle.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.authgoogle.model.Role;
import com.authgoogle.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserPrincipal implements OAuth2User, UserDetails {
    private Long Uid;
    private String email;
    private String password;
    private String name;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(Long uid, String email, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        this.Uid = uid;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.name = name;
    }

    public static UserPrincipal create(User user) {
    	
        List<GrantedAuthority> authoritiesUser = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER" ) ) ;
        List<GrantedAuthority> authoritiesAdmin = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_ADMIN" ) ) ;
        if (user.getRole()==Role.USER) {
        	  return new UserPrincipal(
                      user.getId(),
                      user.getEmail(),
                      user.getName(),
                      user.getPassword(),
                       authoritiesUser
                      
              );	
        }else return (new UserPrincipal(
                      user.getId(),
                      user.getEmail(),
                      user.getName(),
                      user.getPassword(),
                       authoritiesAdmin
                      
              ));

    }
   

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public Long getUid() {
        return Uid;
    }

    public String getUsername() {
        return email;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }



    // TODO: Add profile image url getter
}
