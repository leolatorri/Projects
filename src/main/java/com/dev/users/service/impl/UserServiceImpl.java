package com.dev.users.service.impl;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.domain.entities.User;
import com.dev.users.domain.mapper.MapperUser;
import com.dev.users.domain.mapper.MapperUserDTO;
import com.dev.users.exceptions.EntityNotFoundException;
import com.dev.users.repositories.UserRepository;
import com.dev.users.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUserDTO mapperUserDTO;
    private final MapperUser mapperUser;

    @Override
    public UserDTO findById(Long id) throws EntityNotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        return mapperUserDTO.execute(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        return mapperUserDTO.execute(users);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapperUser.execute(userDTO);
        User createUser = userRepository.save(user);

        return mapperUserDTO.execute(createUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) throws EntityNotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        updateFieldsUsers(existingUser, userDTO);

        User updatedUser = userRepository.save(existingUser);

        return mapperUserDTO.execute(updatedUser);

    }

    private User updateFieldsUsers(User user, UserDTO userDTO) {
        user.setEmail(Objects.nonNull(userDTO.getEmail()) ? userDTO.getEmail() : user.getEmail());
        user.setName(Objects.nonNull(userDTO.getName()) ? userDTO.getName() : user.getName());
        user.setWeight(userDTO.getWeight());
        user.setHeight(userDTO.getHeight());

        return user;
    }
}
