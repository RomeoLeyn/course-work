package com.ternopil.mappers;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    Comment toModel(CommentDTO commentDTO);

    CommentDTO toDto(Comment comment);
}