package com.ternopil.service;

import com.ternopil.DTO.UserDTO;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;


import java.util.List;
import java.util.Optional;


public interface UserService  {
    List<User> getAll();

    void createUser(UserDTO user);

    public void update(User user);

    Optional<User> findById(Long id);

    void remove(Long ID);

    List<User> getAllUsersWithRole(RoleType roleType);

}
