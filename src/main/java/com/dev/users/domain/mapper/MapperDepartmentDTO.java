package com.dev.users.domain.mapper;

import com.dev.users.domain.dtos.DepartmentDTO;
import com.dev.users.domain.entities.Department;

import java.util.List;

public interface MapperDepartmentDTO {

    DepartmentDTO execute(Department department);

    List<DepartmentDTO> execute(List<Department> departments);
}
