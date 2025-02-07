package com.example.authsender.service;

import com.example.authsender.model.UserPrincipal;
import com.example.authsender.model.Users;
import com.example.authsender.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepo.findByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(users);
    }
}
