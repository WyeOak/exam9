package com.exam.forum.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "Themes")
public class Theme {
    @MongoId
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @NotBlank
    private String theme;
    @NotBlank
    private String description;
    @Indexed
    @DBRef
    private User user;
    private LocalDateTime time;
    @Builder.Default
    private int comments = 0;}