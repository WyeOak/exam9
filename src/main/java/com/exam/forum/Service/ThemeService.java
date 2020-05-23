package com.exam.forum.Service;

import com.exam.forum.Model.Theme;
import com.exam.forum.DTO.ThemeDto;
import com.exam.forum.Repository.ThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    public void saveTheme(Theme theme){
        themeRepository.save(theme);
    }

    public Page<ThemeDto> getThemes(Pageable pageable){
        return themeRepository.findAll(pageable).map(ThemeDto::from);
    }

    public ThemeDto getThemeById(Integer themeId){
        return ThemeDto.from(themeRepository.findById(themeId).get());
    }

    public Theme findThemeById(Integer themeId){
        return themeRepository.findById(themeId).get();
    }
}