package com.dev.users.domain.mapper.impl;

import com.dev.users.domain.dtos.DepartmentDTO;

import com.dev.users.domain.entities.Department;
import com.dev.users.domain.mapper.MapperDepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperDepartmentDTOImpl implements MapperDepartmentDTO {

    @Override
    public DepartmentDTO execute(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }

    @Override
    public List<DepartmentDTO> execute(List<Department> departments) {
        return departments.stream()
                .map(this::execute)
                .collect(Collectors.toList());
    }
}
