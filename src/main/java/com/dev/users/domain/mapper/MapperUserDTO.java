package com.dev.users.domain.mapper;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.domain.entities.User;

import java.util.List;

public interface MapperUserDTO {

    UserDTO execute(User user);

    List<UserDTO> execute(List<User> users);

}
