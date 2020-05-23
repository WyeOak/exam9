package com.exam.forum.DTO;

import com.exam.forum.Model.Theme;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThemeDto {
    private Integer id;

    private String title;
    private String timeOfTheme;
    private String user;
    private int amountOfAnswers;

    public static ThemeDto from(Theme theme) {
        return builder()
                .id(theme.getId())
                .title(theme.getTitle())
                .timeOfTheme(theme.getTimeOfTheme().toString())
                .user(theme.getUser().getUsername())
                .amountOfAnswers(theme.getComments().size())
                .build();
    }
}
