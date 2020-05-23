package com.exam.forum.Controller;

import com.exam.forum.Service.CommentService;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
}
