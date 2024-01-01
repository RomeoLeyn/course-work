package com.ternopil.DTO;

import com.ternopil.models.Comment;
import com.ternopil.models.enums.RoleType;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleType roleType;

//    private List<Comment> comments;
}