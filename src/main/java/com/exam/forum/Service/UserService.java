package com.exam.forum.Service;


import com.exam.forum.Model.User;
import com.exam.forum.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void register(UserRegisterForm form) {
        var user = User.builder()
                .firstName(form.getFirstName())
                .lastName((form.getLastName()))
                .password(encoder.encode(form.getPassword()))
                .username(form.getUsername())
                .build();
        userRepository.save(user);
    }

    public boolean existByUsername(UserRegisterForm form){
        return userRepository.existsByUsername(form.getUsername());
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
