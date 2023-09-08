package com.kocesat.mybatisdemo.service;

import com.kocesat.mybatisdemo.model.Department;
import com.kocesat.mybatisdemo.model.dto.DepartmentDto;
import com.kocesat.mybatisdemo.repo.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public Department save(DepartmentDto dto) {
    Department department = new Department();
    department.setName(dto.getName());
    departmentRepository.insert(department);
    return department;
  }

  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  public Department findById(Integer id) {
    List<Department> departments = departmentRepository.findById(id);
    if (departments.isEmpty()) {
      throw new RuntimeException("department not found");
    }
    return departments.get(0);
  }

}
