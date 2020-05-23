package com.exam.forum.Service;


import com.exam.forum.DTO.CommentDto;
import com.exam.forum.Repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Page<CommentDto> getComments(Integer theme_id, Pageable pageable){
        return commentRepository.findAllByThemeId(theme_id, pageable).map(CommentDto::from);
    }
}
