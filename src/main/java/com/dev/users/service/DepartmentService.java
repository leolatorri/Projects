package com.dev.users.service;

import com.dev.users.domain.dtos.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO findById(Long id);
    List<DepartmentDTO> findAll();
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);
}
