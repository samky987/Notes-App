package com.agridence.microservice.Assignment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "NOTE")
@NoArgsConstructor
@Getter
@Setter
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE")
    @NotBlank
    private String title;
    @Column(name = "DESCRIPTION")
    @NotBlank
    private String description;
}
