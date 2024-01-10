package com.ternopil.DTO;

import com.ternopil.models.enums.RoleType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleType roleType;

}