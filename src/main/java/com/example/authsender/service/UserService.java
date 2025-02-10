package com.example.authsender.service;

import com.example.authsender.model.Users;
import com.example.authsender.repo.UserRepo;
import com.example.authsender.config.JWTService.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        //Bcrypt
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users users) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        users.getUsername(),
                        users.getPassword())
                );
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(users.getUsername());
        }
        return "false";
    }
}
