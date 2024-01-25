package com.ternopil.service;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.models.enums.CommentStatus;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CommentService {
    void create(Long userId, Long institutionId, CommentDTO commentDTO);

    List<CommentDTO> getAll(PageRequest pageRequest);

    void update(Long id, CommentDTO commentDTO);

    List<CommentDTO> getAllCommentByInstitutionId(Long id, PageRequest pageRequest);

    List<CommentDTO> getAllCommentByUserId(Long id, PageRequest pageRequest);

    void changeCommentStatus(Long id, CommentStatus status);

    List<CommentDTO> getAllUnModeratedComment(CommentStatus commentStatus, PageRequest pageRequest);

}