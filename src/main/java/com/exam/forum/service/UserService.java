package com.exam.forum.service;


import com.exam.forum.DTO.UserDTO;
import com.exam.forum.exception.UserNotFoundException;
import com.exam.forum.model.User;
import com.exam.forum.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;


    public UserDTO getByEmail(String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return UserDTO.from(user);
    }
    public User getUserByEmail(String email) {
        var user = userRepository.findByEmail(email).get();
        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
