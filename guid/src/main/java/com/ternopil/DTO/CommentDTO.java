package com.ternopil.DTO;

import com.ternopil.models.enums.CommentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long ID;

    private String text;

    private double rating;

    private LocalDateTime written_at;

    CommentStatus status;

    private CommentUserDTO user;

    private CommentInstitutionDTO institution;
}
