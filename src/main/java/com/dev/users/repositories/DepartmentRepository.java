package com.dev.users.repositories;

import com.dev.users.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAll();

    Optional<Department> findById(Long id);
}
