package com.ternopil.repository;

import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUserByRoleType(RoleType roleType);
}