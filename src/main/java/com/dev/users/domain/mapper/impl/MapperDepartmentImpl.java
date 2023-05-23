package com.dev.users.domain.mapper.impl;

import com.dev.users.domain.dtos.DepartmentDTO;
import com.dev.users.domain.entities.Department;
import com.dev.users.domain.mapper.MapperDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperDepartmentImpl implements MapperDepartment {

    @Override
    public Department execute(DepartmentDTO departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .build();
    }

    @Override
    public List<Department> execute(List<DepartmentDTO> departmentDTOS) {
        return departmentDTOS.stream()
                .map(this::execute).toList();
    }
}
