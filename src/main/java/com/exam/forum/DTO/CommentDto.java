package com.exam.forum.DTO;

import com.exam.forum.Model.Comment;
import lombok.Builder;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class CommentDto {
    private Integer id;

    private String user;
    private String timeOfComment;
    private String text;

    public static CommentDto from(Comment comment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return builder()
                .id(comment.getId())
                .user(comment.getUser().getUsername())
                .timeOfComment(comment.getTimeOfComment().format(formatter))
                .text(comment.getText())
                .build();
    }
}
