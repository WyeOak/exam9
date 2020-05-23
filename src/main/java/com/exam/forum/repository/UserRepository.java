package com.exam.forum.repository;


import com.exam.forum.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface UserRepository extends PagingAndSortingRepository<User, String> {
    Optional<User> findByEmail(String email);
    boolean existsByLoginAndEmail(String login, String email);

    boolean existsByEmail(String email);

    void deleteAllById(int id);
}
