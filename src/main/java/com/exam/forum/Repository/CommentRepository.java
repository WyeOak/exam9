package com.exam.forum.Repository;


import com.exam.forum.Model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findAllByThemeId(Integer themeId, Pageable pageable);
}
