package com.ternopil.controllers;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.DTO.UserDTO;
import com.ternopil.models.User;
import com.ternopil.models.enums.RoleType;
import com.ternopil.service.CommentService;
import com.ternopil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    private CommentService commentService;

    @Autowired
    public UserController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    // Add user
    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Get all users
    @GetMapping("/get-all")
    public List<UserDTO> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return userService.getAll(PageRequest.of(page, size, Sort.by("firstName")));
    }

    // Get all moderators/adm
    @GetMapping("/by-role")
    public List<UserDTO> getAllUsersWithRole(
            @RequestParam("roleType") RoleType roleType,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return userService.getAllUsersWithRole(roleType, PageRequest.of(page, size, Sort.by("firstName")));
    }

    // Get user by id
    @GetMapping("/get-by/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable("id") Long ID) {
        return ResponseEntity.ok(userService.findById(ID));
    }

    // Get user by name
    @GetMapping("/find-by-name")
    public List<UserDTO> getUsersByName(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
            ) {
        return userService.getUserByName(name, PageRequest.of(page, size));
    }

    @GetMapping("/{id}/comments")
    List<CommentDTO> getAllUsersComments(@PathVariable Long id,
                                         @RequestParam(required = false, defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "10") int size) {
        return commentService.getAllCommentByUserId(id, PageRequest.of(page, size));
    }

    // Update user by id
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
    }

    // Delete user by id
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable("id") Long ID) {
        userService.remove(ID);
    }
}