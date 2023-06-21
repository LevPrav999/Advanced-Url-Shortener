package ru.levprav.services.authservice.vo;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    private String login;

    @Size(min = 6, message = "Password should be more than 6 letters!")
    private String password;
}