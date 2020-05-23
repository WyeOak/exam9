package com.exam.forum.repository;


import com.exam.forum.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {

}
