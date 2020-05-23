package com.exam.forum.Controller;


import com.exam.forum.Exception.UserAlreadyRegisteredException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = UserAlreadyRegisteredException.class)
    public String exception(UserAlreadyRegisteredException exception, Model model) {
        model.addAttribute("exception", exception);
        return "register";
    }
}