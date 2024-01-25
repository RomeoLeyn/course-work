//package com.ternopil.service.serviceImpl;
//
//import com.ternopil.models.User;
//import com.ternopil.repository.UserDetailsRepository;
//import com.ternopil.security.PersonDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PersonDetailsService implements UserDetailsService {
//    private final UserDetailsRepository userDetailsRepository;
//
//    public PersonDetailsService(UserDetailsRepository userDetailsRepository) {
//        this.userDetailsRepository = userDetailsRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userDetailsRepository.findByFirstName(username);
//
//        if (user.isEmpty())
//            throw new UsernameNotFoundException("User not found");
//
//        return new PersonDetails(user.get());
//    }
//}