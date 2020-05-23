package com.exam.forum.Controller;


import com.exam.forum.Exception.UserAlreadyRegisteredException;
import com.exam.forum.Service.UserRegisterForm;
import com.exam.forum.Service.CommentService;
import com.exam.forum.Service.PropertiesService;
import com.exam.forum.Service.ThemeService;
import com.exam.forum.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class FrontEndController {

    private final UserService userService;
    private final ThemeService themeService;
    private final PropertiesService propertiesService;
    private final CommentService commentService;

    @GetMapping("/")
    public String getMainPage(Model model, Pageable pageable, HttpServletRequest uriBuilder){
        var themes = themeService.getThemes(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(themes, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("user_status", getUserStatus());
        return "index";
    }

    @GetMapping("/theme/{theme_id}")
    public String themePage(@PathVariable("theme_id") Integer theme_id, Model model, Pageable pageable,
                            HttpServletRequest uriBuilder){
        model.addAttribute("theme", themeService.getThemeById(theme_id));
        var comments = commentService.getComments(theme_id, pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(comments, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("user_status", getUserStatus());
        return "theme";
    }

    @GetMapping("/create/theme")
    public String createTheme(Model model){
        model.addAttribute("user_status", getUserStatus());
        return "createTheme";
    }

    @GetMapping("/register")
    public String registerUserPage(Model model){
        model.addAttribute("user_status", getUserStatus());

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserRegisterForm());
        }
        return "register";
    }


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user_status", getUserStatus());
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(Model model){
        model.addAttribute("user_status", getUserStatus());
        return "profile";
    }

    private String getUserStatus(){
        String user_status;
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        try{
            user_status = (String)authentication.getPrincipal();
        }
        catch (Exception ex){
            user_status = "authorizedUser";
        }
        return user_status;
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterForm user, BindingResult validationResult, RedirectAttributes attributes){
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }
        else{
            if(userService.existByUsername(user)){
                throw new UserAlreadyRegisteredException("User with this username is already registered! Please, try again.");
            }
            userService.register(user);
            return "redirect:/login";
        }
    }

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink",
                    constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink",
                    constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }
}
