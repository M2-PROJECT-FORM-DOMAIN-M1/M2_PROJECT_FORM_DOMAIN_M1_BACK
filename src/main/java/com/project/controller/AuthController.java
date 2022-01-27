package com.project.controller;

import com.project.component.JwtTokenProvider;
import com.project.database.models.users.Users;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.connection.LoginRequest;
import com.project.dto.responses.connection.IsAuthentificatedResponse;
import com.project.dto.responses.connection.JwtAuthenticationResponse;
import com.project.models.UserPrincipalFront;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AuthController extends AbstractController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsersRepository usersRepository;


    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;


    @PostMapping("/auth/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipalName = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.findById(currentPrincipalName.getId()).
                orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + loginRequest.getUsernameOrEmail()));

        users.setPassword("");
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, users));


    }

    @PostMapping("/auth/isConnected")
    public ResponseEntity<?> authenticateUser() {
        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipalName = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.findById(currentPrincipalName.getId()).
                orElseThrow(() ->
                        new UsernameNotFoundException("User not found with id : " + currentPrincipalName.getId()));

        users.setPassword("");
        return ResponseEntity.ok(new IsAuthentificatedResponse(true, "user is connected", true, users));
    }


}
