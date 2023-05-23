package com.dev.users.domain.mapper.impl;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.domain.entities.User;
import com.dev.users.domain.mapper.MapperUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperUserImpl implements MapperUser {

    @Override
    public User execute(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .height(userDTO.getHeight())
                .weight(userDTO.getWeight())
                .build();
    }

    @Override
    public List<User> execute(List<UserDTO> userDTOS) {
        return userDTOS.stream()
                .map(this::execute).toList();
    }
}
