package com.exam.forum.Service;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRegisterForm {
    @Size(min=4, max=40, message = "length must be >= 4 and <= 40")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "should contain only letters")
    private String firstName = "";

    @Size(min=4, max=40, message = "length must be >= 4 and <= 40")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "should contain only letters")
    private String lastName = "";

    @NotBlank
    @Size(min=3, max=40, message = "Length must be >= 3 and <= 40")
    private String username = "";

    @NotBlank
    @Size(min=5, max=40, message = "password must contain > 5 and < 30 symbols")
    private String password = "";

    @NotBlank
    private String gender = "";
}
