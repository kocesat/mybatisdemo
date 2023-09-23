package com.kocesat.mybatisdemo.mapper.school;

import com.kocesat.mybatisdemo.model.school.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

  void insert(Department department);
  List<Department> findAll();
  List<Department> findById(Integer id);
}
