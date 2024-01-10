package com.ternopil.service.serviceImpl;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.mappers.CommentMapper;
import com.ternopil.models.Comment;
import com.ternopil.models.Institution;
import com.ternopil.models.User;
import com.ternopil.repository.CommentRepository;
import com.ternopil.repository.InstitutionRepository;
import com.ternopil.repository.UserRepository;
import com.ternopil.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public void addComment(Long userId, Long institutionId, CommentDTO commentDTO) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Користувача із заданим ID не знайдено"));


        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new IllegalArgumentException("Заклад із заданим ID не знайдено"));


        Comment comment = CommentMapper.INSTANCE.toModel(commentDTO);

        comment.setUser(user);

        comment.setInstitution(institution);

        commentRepository.save(comment);
    }
}
