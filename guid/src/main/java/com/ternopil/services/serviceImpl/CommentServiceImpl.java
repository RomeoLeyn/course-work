package com.ternopil.services.serviceImpl;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.exeption.NotFoundException;
import com.ternopil.mappers.CommentMapper;
import com.ternopil.models.Comment;
import com.ternopil.models.Institution;
import com.ternopil.models.User;
import com.ternopil.models.enums.CommentStatus;
import com.ternopil.repository.CommentRepository;
import com.ternopil.repository.InstitutionRepository;
import com.ternopil.repository.UserRepository;
import com.ternopil.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final InstitutionRepository institutionRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, InstitutionRepository institutionRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void create(Long userId, Long institutionId, CommentDTO commentDTO) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Користувача із заданим ID не знайдено"));

        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new IllegalArgumentException("Заклад із заданим ID не знайдено"));

        Comment comment = CommentMapper.INSTANCE.toModel(commentDTO);
        comment.setUser(user);
        comment.setInstitution(institution);
        comment.setWritten_at(LocalDateTime.now());
        comment.setStatus(CommentStatus.UN_MODERATED);

        commentRepository.save(comment);
    }


    @Override
    public void update(Long id, CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));

        existingComment.setText(commentDTO.getText());
        existingComment.setRating(commentDTO.getRating());

        commentRepository.save(existingComment);
    }



    @Override
    public List<CommentDTO> getAll(PageRequest pageRequest) {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getAllUnModeratedComment(CommentStatus commentStatus, PageRequest pageRequest) {
        List<Comment> comments = commentRepository.getCommentByStatus(commentStatus);
        return comments.stream().map(CommentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getAllCommentByInstitutionId(Long id, PageRequest pageRequest) {
        List<Comment> comments = commentRepository.findByInstitutionID(id, pageRequest);
        return comments.stream().map(CommentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getAllCommentByUserId(Long id, PageRequest pageRequest) {
        List<Comment> comments = commentRepository.findByUserID(id, pageRequest);
        return comments.stream().map(CommentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public void changeCommentStatus(Long id, CommentStatus status) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));

        existingComment.setStatus(status);

        commentRepository.save(existingComment);
    }

}