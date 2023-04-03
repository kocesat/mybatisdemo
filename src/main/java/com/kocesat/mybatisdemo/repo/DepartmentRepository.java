package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentRepository {

  void insert(Department department);
  List<Department> findAll();
  List<Department> findById(Integer id);
}
