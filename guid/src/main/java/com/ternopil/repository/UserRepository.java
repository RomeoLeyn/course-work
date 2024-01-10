package com.ternopil.repository;

import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> getUserByRoleType(RoleType roleType, PageRequest pageRequest);
    Page<User> getUserByFirstNameContainingIgnoreCase(String name, PageRequest pageRequest);
}