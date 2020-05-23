package com.exam.forum.util;


import com.exam.forum.model.Comment;
import com.exam.forum.model.Theme;
import com.exam.forum.model.User;
import com.exam.forum.repository.CommentRepository;
import com.exam.forum.repository.ThemeRepository;
import com.exam.forum.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class DBPreload {
    private Random r = new Random();

    @Bean
    CommandLineRunner generateGibberish(UserRepository userRepo, ThemeRepository themeRepo, CommentRepository commentRepo) {
        return args -> {
            userRepo.deleteAll();
            themeRepo.deleteAll();
            commentRepo.deleteAll();

            var users = Stream.generate(User::make).limit(5).collect(toList());
            var myUser = User.builder()
                    .login("kurs")
                    .email("kurs@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("qwerty"))
                    .build();
            users.add(myUser);


            List<Theme> themes = new ArrayList<>();
            for(int a=1;a<=50;a++) {
                var u = users.get(r.nextInt(users.size()));
                var t = Theme.make(u);
                themes.add(t);

            }


            List<Comment> comments = new ArrayList<>();
            for(int b=1;b<=50;b++){
                var u = users.get(r.nextInt(users.size()));
                u.plusComment();
                users.add(u);
                var t = themes.get(r.nextInt(themes.size()));
                var c = Comment.make(u, t);
                t.plusComment();
                themes.add(t);
                comments.add(c);
            }
            userRepo.saveAll(users);
            themeRepo.saveAll(themes);
            commentRepo.saveAll(comments);

        };
    }
}
