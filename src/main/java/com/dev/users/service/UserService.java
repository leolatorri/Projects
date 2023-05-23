package com.dev.users.service;

import com.dev.users.domain.dtos.UserDTO;


import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    List<UserDTO> findAll();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);

}
