package com.ternopil.controllers;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.models.Comment;
import com.ternopil.models.enums.CommentStatus;
import com.ternopil.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @PostMapping("/{userId}/{institutionId}")
    public void createComment(@PathVariable Long userId, @PathVariable Long institutionId, @RequestBody CommentDTO commentDTO) {
        commentService.create(userId, institutionId, commentDTO);
    }

    @GetMapping
    public List<CommentDTO> getAllComments(@RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "10") int size) {
        return commentService.getAll(PageRequest.of(page, size));
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        commentService.update(id, commentDTO);
    }

    // Get un-moderated comments
    @GetMapping("/un-moderated")
    public List<CommentDTO> getAllUnModeratedComment(
            @RequestParam CommentStatus commentStatus,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return commentService.getAllUnModeratedComment(commentStatus, PageRequest.of(page, size));
    }

    // Update commentstatus (use only admin/moderator)
    @PutMapping("/change-status/{id}")
    public void changeUnModeratedComment(@PathVariable Long id, @RequestParam CommentStatus status) {
        commentService.changeCommentStatus(id, status);
    }
}