package com.ternopil.controllers;

import com.ternopil.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    // Add user
    @PostMapping
    public void postUser(@RequestBody User user) {

    }

    // Get user by id
    @GetMapping("/{id}")
    public User findByID(@PathVariable Long ID) {
        return null;
    }

    // Update user by id
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long ID, @RequestBody User user) {

    }

    // Delete user by id
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long ID) {

    }

    // Get all moderators/adm
    @GetMapping("/user/{role}")
    public List<User> getAllUsersWithRole(String role) {
        return null;
    }
}