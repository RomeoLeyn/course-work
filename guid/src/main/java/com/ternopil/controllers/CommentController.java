package com.ternopil.controllers;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.models.Comment;
import com.ternopil.service.CommentService;
import jakarta.ws.rs.Path;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // TODO: 10.01.2024 Доробити додавання коментарів та додавання робочих днів 
    @PostMapping("/addComment/{userId}/{institutionId}")
    public void addComment(@PathVariable Long userId, @PathVariable Long institutionId, @RequestBody CommentDTO commentDTO) {
        commentService.addComment(userId, institutionId, commentDTO);
    }

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