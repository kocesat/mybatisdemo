package com.kocesat.mybatisdemo.service;

import com.kocesat.mybatisdemo.model.Department;
import com.kocesat.mybatisdemo.repo.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  public List<Department> findById(Integer id) {
    return departmentRepository.findById(id);
  }

}
