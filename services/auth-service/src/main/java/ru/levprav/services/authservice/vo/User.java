package ru.levprav.services.authservice.vo;

import lombok.*;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private Long id;

    @NonNull
    private String login;

    @NonNull
    private String password;

    private String description;
}
