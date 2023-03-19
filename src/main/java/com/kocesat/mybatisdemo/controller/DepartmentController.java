package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.model.Department;
import com.kocesat.mybatisdemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService departmentService;

  @GetMapping
  public List<Department> getAll() {
    return departmentService.findAll();
  }

  @GetMapping("/{id}")
  public List<Department> getById(@PathVariable("id") Integer id) {
    return departmentService.findById(id);
  }
}
