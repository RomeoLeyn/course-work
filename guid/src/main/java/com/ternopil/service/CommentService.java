package com.ternopil.service;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.models.Comment;

public interface CommentService {
    void addComment(Long userId, Long institutionId, CommentDTO commentDTO);
}
