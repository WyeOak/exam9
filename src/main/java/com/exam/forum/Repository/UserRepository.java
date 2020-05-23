package com.exam.forum.Repository;

import com.exam.forum.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    User findById(int id);
    User findByUsername(String username);
}
