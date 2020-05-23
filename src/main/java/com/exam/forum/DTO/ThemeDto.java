package com.exam.forum.DTO;

import com.exam.forum.Model.Theme;
import lombok.Builder;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class ThemeDto {
    private Integer id;

    private String title;
    private String timeOfTheme;
    private String user;
    private int amountOfAnswers;

    public static ThemeDto from(Theme theme) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return builder()
                .id(theme.getId())
                .title(theme.getTitle())
                .timeOfTheme(theme.getTimeOfTheme().format(formatter))
                .user(theme.getUser().getUsername())
                .amountOfAnswers(theme.getComments().size())
                .build();
    }
}
