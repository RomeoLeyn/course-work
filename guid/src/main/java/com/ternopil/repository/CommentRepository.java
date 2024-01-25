package com.ternopil.repository;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.models.Comment;
import com.ternopil.models.enums.CommentStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentByStatus(CommentStatus commentStatus);

    List<Comment> findByInstitutionID(Long id, PageRequest pageRequest);

    List<Comment> findByUserID(Long id, PageRequest pageRequest);
}
