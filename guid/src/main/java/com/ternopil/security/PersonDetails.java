//package com.ternopil.security;
//
//import com.ternopil.models.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class PersonDetails implements UserDetails {
//
//    private final User user;
//
//    public PersonDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null; // TODO: 20.01.2024 return role user
//    }
//
//    @Override
//    public String getPassword() {
//        return this.user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.user.getFirstName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public User getUser() {
//        return this.user;
//    }
//}