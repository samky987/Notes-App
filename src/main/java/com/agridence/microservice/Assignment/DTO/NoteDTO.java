package com.agridence.microservice.Assignment.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoteDTO
{
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
