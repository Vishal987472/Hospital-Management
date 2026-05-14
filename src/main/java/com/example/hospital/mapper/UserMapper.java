package com.example.hospital.mapper;

import com.example.hospital.dto.ResponseUserDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseUserDto userToUserDto(User user);
    User toEntity(UserDto userDto);

}
