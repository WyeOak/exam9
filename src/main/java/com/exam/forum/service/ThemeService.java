package com.exam.forum.service;


import com.exam.forum.DTO.ThemeDTO;
import com.exam.forum.model.Theme;
import com.exam.forum.repository.ThemeRepository;
import com.exam.forum.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeService {
    private final ThemeRepository repository;
    private final UserRepository userRepository;

    public Page<ThemeDTO> getAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("time").descending());
        return repository.findAll(pageable).map(ThemeDTO::from);
    }

    public ThemeDTO getById(String themeId) {
        var t = repository.findById(themeId).get();
        return ThemeDTO.from(t);
    }


    public Theme getTheme(String id) {
        var t = repository.findById(id).get();
        t.plusComment();
        repository.save(t);
        return t;
    }
}
