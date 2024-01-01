package com.ternopil.controllers;

import com.ternopil.DTO.UserDTO;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import com.ternopil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add user
    @PostMapping
    public void postUser(@RequestBody UserDTO user) {
        userService.createUser(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    // Get user by id
    @GetMapping("/{id}")
    public Optional<User> findByID(@PathVariable("id") Long ID) {
        return userService.findById(ID);
    }

    // Update user by id
    @PutMapping("/update/{id}")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    // Delete user by id
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable("id") Long ID) {
        userService.remove(ID);
    }

    // Get all moderators/adm
    @GetMapping("/by-role")
    public List<User> getAllUsersWithRole(@RequestParam("roleType") RoleType roleType) {
        return userService.getAllUsersWithRole(roleType);
    }
}