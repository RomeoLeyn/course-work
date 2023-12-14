package com.ternopil.controllers;

import com.ternopil.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    // Get all institution comment
    @GetMapping("/institution/{id}/comments")
    public List<Comment> getAllInstitutionComments(Long ID) {
        return null;
    }

    // Get all user comments
    @GetMapping("/user/{id}/comments")
    public List<Comment> getAllUserComments(Long ID) {
        return null;
    }

    // Get unmodarated comments
    @GetMapping("/comments/{status}")
    public List<Comment> getAllUnModeratedComment(String status) {
        return null;
    }
}