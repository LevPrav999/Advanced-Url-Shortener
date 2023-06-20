package ru.levprav.services.authservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @Email(message = "Login is not valid!")
    private String login;

    @Size(min = 6, message = "Password should be more than 6 letters!")
    private String password;
}