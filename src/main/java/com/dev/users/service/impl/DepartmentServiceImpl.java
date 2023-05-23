package com.dev.users.service.impl;

import com.dev.users.domain.dtos.DepartmentDTO;
import com.dev.users.domain.entities.Department;
import com.dev.users.domain.mapper.MapperDepartment;
import com.dev.users.domain.mapper.MapperDepartmentDTO;
import com.dev.users.exceptions.EntityNotFoundException;
import com.dev.users.repositories.DepartmentRepository;
import com.dev.users.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final MapperDepartmentDTO mapperDepartmentDTO;
    private final MapperDepartment mapperDepartment;

    @Override
    public DepartmentDTO findById(Long id)  throws EntityNotFoundException{
        var department =  departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        return mapperDepartmentDTO.execute(department);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();

        return mapperDepartmentDTO.execute(departments);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = mapperDepartment.execute(departmentDTO);
        Department createDepartment = departmentRepository.save(department);

        return mapperDepartmentDTO.execute(createDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) throws EntityNotFoundException{
        Department existsDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        updateFields(existsDepartment, departmentDTO);

        Department updateDepartment = departmentRepository.save(existsDepartment);

        return mapperDepartmentDTO.execute(updateDepartment);
    }

    private Department updateFields(Department department, DepartmentDTO departmentDTO) {
        department.setId(Objects.nonNull(departmentDTO.getId()) ? departmentDTO.getId() : department.getId());
        department.setName(Objects.nonNull(departmentDTO.getName()) ? departmentDTO.getName() : department.getName());

        return department;
    }

}
