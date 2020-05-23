package com.exam.forum.repository;


import com.exam.forum.model.Theme;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ThemeRepository extends PagingAndSortingRepository<Theme, String> {

}
