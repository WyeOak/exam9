package com.exam.forum.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Themes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column(length = 500)
    private String text;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "theme_ldt")
    @Builder.Default
    private LocalDateTime timeOfTheme = LocalDateTime.now();

    @OneToMany(mappedBy = "theme")
    List<Comment> comments;
}
