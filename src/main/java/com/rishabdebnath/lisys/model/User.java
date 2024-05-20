package com.rishabdebnath.lisys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name= "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username should not be blank")
    @NotBlank(message = "Username should not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid username")
    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Invalid password")
    @NotBlank
    @Column(length = 100, nullable = false)
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
