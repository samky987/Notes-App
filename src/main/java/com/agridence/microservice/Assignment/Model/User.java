package com.agridence.microservice.Assignment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "USER_PROFILE") //User is reserved keyword in Postgres
@Getter
@Setter
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "FULL_NAME")
    @NotBlank
    private String fullName;
    @Column(name = "USER_NAME")
    @NotBlank
    private String username;
    @Column(name = "PASSWORD")
    @NotBlank
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "NOTES")
    private List<Note> notes;
    public User(String fullName, String username, String password)
    {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }
}
