package com.exam.forum.DTO;

import com.exam.forum.Model.Comment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Integer id;

    private String user;
    private String timeOfComment;
    private String text;

    public static CommentDto from(Comment comment) {
        return builder()
                .id(comment.getId())
                .user(comment.getUser().getUsername())
                .timeOfComment(comment.getTimeOfComment().toString())
                .text(comment.getText())
                .build();
    }
}
