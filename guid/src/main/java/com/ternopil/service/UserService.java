package com.ternopil.service;

import com.ternopil.DTO.UserDTO;
import com.ternopil.models.enums.RoleType;
import org.springframework.data.domain.PageRequest;


import java.util.List;


public interface UserService  {

    void createUser(UserDTO userDTO);

    void update(Long ID, UserDTO userDTO);

    UserDTO findById(Long id);

    void remove(Long ID);

    List<UserDTO> getAllUsersWithRole(RoleType roleType, PageRequest pageRequest);

    List<UserDTO> getAll(PageRequest pageRequest);

    List<UserDTO> getUserByName(String name, PageRequest pageRequest);
}
