package com.dev.users.controllers;

import com.dev.users.domain.dtos.UserDTO;
import com.dev.users.exceptions.EntityNotFoundException;
import com.dev.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks( this);
        userController = new UserController(userService);
    }
    @Test
    void itShouldReturnUsers_WhenFindAll() {
        //given
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO());
        userDTOList.add(new UserDTO());

        when(userService.findAll()).thenReturn(userDTOList);

        //when
        ResponseEntity<List<UserDTO>> responseEntity = userController.findAll();

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userDTOList, responseEntity.getBody());
        verify(userService, times(1)).findAll();
    }

    @Test
    void itShouldReturnUser_WhenFindById() {
        //given
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        when(userService.findById(1L)).thenReturn(userDTO);

        //when
        ResponseEntity<UserDTO> responseEntity = userController.findById(1L);

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userDTO, responseEntity.getBody());
        verify(userService, times(1)).findById(1L);
    }

    @Test
    void itShouldReturnCreated_WhenCreateUser() {
        // given
        UserDTO userDTO = new UserDTO();
        when(userService.createUser(userDTO)).thenReturn(userDTO);

        // when
        ResponseEntity<UserDTO> responseEntity = userController.create(userDTO);

        // then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(userDTO, responseEntity.getBody());
        verify(userService, times(1)).createUser(userDTO);
    }

    @Test
    void itShouldReturnOk_WhenUpdateUser() {
        //given
        UserDTO userDTO = new UserDTO();
        when(userService.updateUser(1L, userDTO)).thenReturn(userDTO);

        //when
        ResponseEntity<UserDTO> responseEntity = userController.update(1L, userDTO);

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userDTO, responseEntity.getBody());
        verify(userService, times(1)).updateUser(1L, userDTO);
    }
}
