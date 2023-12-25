package com.ternopil.controllers;

import com.ternopil.models.User;
import com.ternopil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Add user
    @PostMapping
    public void postUser(@RequestBody User user) {
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
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long ID, @RequestBody User user) {

    }

    // Delete user by id
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") Long ID) {
        userService.remove(ID);
    }

    // Get all moderators/adm
    @GetMapping("/user/{role}")
    public List<User> getAllUsersWithRole() {
        return userService.getAllUsersWithRole();
    }
}