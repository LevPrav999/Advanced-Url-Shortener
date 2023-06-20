package ru.levprav.services.linksservice.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkDto {
    @Size(max = 85, message = "Url is too long!")
    private String targetURL;
}
