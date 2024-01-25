package com.ternopil.repository;

import com.ternopil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstName(String firstName);
}
