package com.dev.users.domain.mapper;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.domain.entities.User;

import java.util.List;

public interface MapperUser {

     User execute(UserDTO userDTO);

     List<User> execute(List<UserDTO> userDTOS);
}
