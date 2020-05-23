package com.exam.forum.Repository;

import com.exam.forum.Model.Comment;
import com.exam.forum.Model.Theme;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ThemeRepository extends PagingAndSortingRepository<Theme, Long> {
}
