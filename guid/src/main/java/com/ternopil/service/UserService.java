package com.ternopil.service;

import com.ternopil.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService  {
    List<User> getAll();

    void createUser(User user);

    Optional<User> findById(Long id);

    void update(User User);

    void remove(Long ID);

    List<User> getAllUsersWithRole();

}
