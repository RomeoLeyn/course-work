package com.ternopil.DTO;

import com.ternopil.models.enums.RoleType;
import lombok.Data;

@Data
public class CommentUserDTO {
    private Long ID;

    private String firstName;

    private String lastName;

    private RoleType roleType;
}
