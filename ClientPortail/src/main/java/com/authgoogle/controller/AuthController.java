package com.authgoogle.controller;
import com.authgoogle.security.UserPrincipal;
import com.authgoogle.*;
import com.authgoogle.exception.BadRequestException;
import com.authgoogle.model.AuthProvider;
import com.authgoogle.model.User;
import com.authgoogle.payload.ApiResponse;
import com.authgoogle.payload.AuthResponse;
import com.authgoogle.payload.LoginRequest;
import com.authgoogle.payload.SignUpRequest;
import com.authgoogle.repository.UserRepository;
import com.authgoogle.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try{
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        UserPrincipal customUser = (UserPrincipal)authentication.getPrincipal();
        return ResponseEntity.ok(new AuthResponse(token, customUser));
        }
        catch(BadCredentialsException e){
            return ResponseEntity.ok(new AuthResponse("Bad Credentials"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.ok(new ApiResponse(false, "Email Address already exists"));
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);

        // Auto authenticate the newly signed-up account
        UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.getEmail());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
        new UsernamePasswordAuthenticationToken(signUpRequest.getEmail(), 
                                                signUpRequest.getPassword(), 
                                                userDetails.getAuthorities());
        
        Authentication authentication = 
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token, userDetails));
    }


}