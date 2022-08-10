package com.example.backend.model;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String name;
    @Email
    @NotNull
    private String email;
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[\\d].*[\\d])[a-zA-Z\\d]{8,12})$",
            message = "Password should be 8-12 characters long, including an uppercase letter and two numbers")
    @NotNull
    private String password;

    private List<Phones> phones;
}
