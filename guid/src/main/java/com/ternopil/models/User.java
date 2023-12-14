package com.ternopil.models;

import com.ternopil.models.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter @Getter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_type")
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    private List<Comment> coments;
}