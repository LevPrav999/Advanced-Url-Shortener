package ru.levprav.services.authservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tokens")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String value;

    @NonNull
    private Long userId;
}
