package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.base.Pageable;
import com.kocesat.mybatisdemo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentRepository {
  void save(Student student);
  Student findById(Integer id);
  List<Student> findAllWithPage(Pageable pageable);
  List<Student> findByFirstName(String firstName);
  void update(Student student);
  void deleteById(int id);
  Student selectByExample(Student student);
  List<Student> getByMultipleId(List<Integer> ids);
  List<Student> findAll();
}
