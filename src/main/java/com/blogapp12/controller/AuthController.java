package com.blogapp12.controller;

import com.blogapp12.entity.User;
import com.blogapp12.payload.LoginDto;
import com.blogapp12.payload.Signup;
import com.blogapp12.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    http://localhost:8080/api/auth/sign-up
@PostMapping("/sign-up")
    public ResponseEntity<String> createUser(@RequestBody Signup signup) {
        if (userRepository.existsByEmail(signup.getEmail())) {
            return new ResponseEntity<>("email id is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (userRepository.existsByUsername(signup.getEmail())) {
            return new ResponseEntity<>("user name is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        User user = new User();
        user.setName(signup.getName());
        user.setUsername(signup.getUsername());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));

        userRepository.save(user);
        return new ResponseEntity<>("user is  registered", HttpStatus.CREATED);
    }
    @PostMapping("/sign-in")
    public ResponseEntity <String> signIn(@RequestBody LoginDto loginDto){

    //supply loginDto.getUsername()-username to LoadByUser method in CustomUserDetail class
        // it will compare
        // Expected credentials- loginDto.getUsername(),loginDto.getPassword
        // With actual credential given by LoadByUser method

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
        new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //Similar yto session variable

        SecurityContextHolder.getContext().setAuthentication(authenticate);
     return new ResponseEntity<>("sign in successful",HttpStatus.OK);
    }
}
