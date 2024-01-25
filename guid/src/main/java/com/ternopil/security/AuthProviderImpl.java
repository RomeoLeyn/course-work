//package com.ternopil.security;
//
//import com.ternopil.service.serviceImpl.PersonDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class AuthProviderImpl implements AuthenticationProvider {
//
//    private final PersonDetailsService userDetailsService;
//
//    @Autowired
//    public AuthProviderImpl(PersonDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName();
//        UserDetails personDetails =  userDetailsService.loadUserByUsername(name);
//
//        String password = authentication.getCredentials().toString();
//
//        if (!password.matches(personDetails.getPassword()))
//            throw new BadCredentialsException("Incorrect password");
//
//        return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}