package com.dev.users.domain.mapper;

import com.dev.users.domain.dtos.DepartmentDTO;
import com.dev.users.domain.entities.Department;

import java.util.List;

public interface MapperDepartment {

    Department execute(DepartmentDTO departmentDTO);

    List<Department> execute(List<DepartmentDTO> departmentDTOS);

}
