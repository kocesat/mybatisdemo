package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.model.Department;
import com.kocesat.mybatisdemo.model.dto.DepartmentDto;
import com.kocesat.mybatisdemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService departmentService;

  @PostMapping
  public DepartmentDto create(@RequestBody DepartmentDto dto) {
    final Department department = departmentService.save(dto);
    return DepartmentDto.from(department);
  }

  @GetMapping
  public List<Department> getAll() {
    return departmentService.findAll();
  }

  @GetMapping("/{id}")
  public Department getById(@PathVariable("id") Integer id) {
    return departmentService.findById(id);
  }
}
