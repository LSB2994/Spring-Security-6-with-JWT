//package com.example.authsender.appuser;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class AppUserService implements UserDetailsService {
//
//    private final static String USR_NOT_FOUND_MGS = "User with email %s not found";
//
//    private final AppUserRepository appUserRepository;
//
//    public AppUser findByUsername(String username){
//        return appUserRepository.findAppUserByUsername(username);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//        return appUserRepository.findByEmail(email)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(String.format(USR_NOT_FOUND_MGS,email)
//                        )
//                );
//    }
//}
