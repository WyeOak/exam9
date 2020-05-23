package com.exam.forum.service;


import com.exam.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = repository.findByEmail(email);
        if(user != null) {
            return user.get();
        }
        throw new UsernameNotFoundException(String.format("User: %s not found", email));
    }
}
