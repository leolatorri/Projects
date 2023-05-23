package com.dev.users.domain.mapper.impl;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.domain.entities.User;
import com.dev.users.domain.mapper.MapperUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperUserDTOImpl implements MapperUserDTO {

    @Override
    public UserDTO execute(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .weight(user.getWeight())
                .height(user.getHeight())
                .build();
    }

    @Override
    public List<UserDTO> execute(List<User> users) {
        return users.stream()
                .map(this::execute)
                .collect(Collectors.toList());
    }


}
