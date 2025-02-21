package com.Ikbsu.controller;


import com.Ikbsu.dto.AuthRequest;
import com.Ikbsu.dto.CustomResponse;
import com.Ikbsu.dto.ErrorResponse;
import com.Ikbsu.jwt.JwtUtil;
import com.Ikbsu.model.User;
import com.Ikbsu.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
//    public String login(@RequestBody AuthRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
//        return jwtUtil.generateToken(userDetails);  // Return the JWT token
//    }
    public ResponseEntity<CustomResponse<String>> login(@RequestBody AuthRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtUtil.generateToken(userDetails);

            CustomResponse<String> response = new CustomResponse<>(token, null);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            List<ErrorResponse> errors = List.of(new ErrorResponse("INVALID_CREDENTIALS","Invalid username/password"));
            CustomResponse<String> response = new CustomResponse<>(null, errors);
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(response);
        }
    }

}
