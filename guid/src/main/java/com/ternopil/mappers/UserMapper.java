package com.ternopil.mappers;

import com.ternopil.DTO.UserAuthDTO;
import com.ternopil.DTO.UserDTO;
import com.ternopil.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    User toModel(UserDTO userDTO);
    User toAuthModel(UserAuthDTO userAuthDTO);
}