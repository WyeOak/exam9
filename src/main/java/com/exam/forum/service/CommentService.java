package com.exam.forum.service;

import com.exam.forum.DTO.CommentDTO;
import com.exam.forum.model.Comment;
import com.exam.forum.repository.CommentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentService {
    private final CommentRepository repository;

    public Page<CommentDTO> getAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 1, Sort.by("time").descending());
        return repository.findAll(pageable).map(CommentDTO::from);
    }

    public void saveComment(Comment comment) {
        repository.save(comment);
    }

    public Comment getComment(String id) {
        return repository.findById(id).get();
    }
}
