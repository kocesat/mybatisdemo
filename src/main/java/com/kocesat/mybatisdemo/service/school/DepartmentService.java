package com.kocesat.mybatisdemo.service.school;

import com.kocesat.mybatisdemo.model.school.Department;
import com.kocesat.mybatisdemo.model.school.dto.DepartmentDto;
import com.kocesat.mybatisdemo.mapper.school.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentMapper departmentMapper;

  public Department save(DepartmentDto dto) {
    Department department = new Department();
    department.setName(dto.getName());
    departmentMapper.insert(department);
    return department;
  }

  public List<Department> findAll() {
    return departmentMapper.findAll();
  }

  public Department findById(Integer id) {
    List<Department> departments = departmentMapper.findById(id);
    if (departments.isEmpty()) {
      throw new RuntimeException("department not found");
    }
    return departments.get(0);
  }

}
