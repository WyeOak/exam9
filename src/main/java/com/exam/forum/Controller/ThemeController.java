package com.exam.forum.Controller;

import com.exam.forum.Model.Comment;
import com.exam.forum.Model.Theme;
import com.exam.forum.Service.CommentService;
import com.exam.forum.Service.ThemeService;
import com.exam.forum.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ThemeController {

    private final ThemeService themeService;
    private final UserService userService;
    private final CommentService commentService;


    @PostMapping("/theme/add/comment")
    public void addComment(@RequestParam("theme_id") Integer theme_id, @RequestParam("text") String text){
        Comment comment = new Comment();
        comment.setUser(userService.findByUsername(getUsername()));
        comment.setText(text);
        comment.setTheme(themeService.findThemeById(theme_id));
        commentService.saveComment(comment);
    }

    @PostMapping("/create/theme")
    public String createTheme(@RequestParam("title") String title, @RequestParam("main_text") String text){
        Theme theme = new Theme();
        theme.setTitle(title);
        theme.setText(text);
        theme.setUser(userService.findByUsername(getUsername()));
        themeService.saveTheme(theme);
        return "redirect:/";
    }

    private String getUsername(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
