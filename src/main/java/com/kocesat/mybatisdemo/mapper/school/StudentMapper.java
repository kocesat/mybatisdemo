package com.kocesat.mybatisdemo.mapper.school;

import com.kocesat.mybatisdemo.base.Pageable;
import com.kocesat.mybatisdemo.model.school.Student;
import com.kocesat.mybatisdemo.model.school.StudentFeePayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
  void save(Student student);
  Student findById(Integer id);
  List<Student> findAllWithPage(Pageable pageable);
  List<StudentFeePayment> findAllWithFeePayments();
  List<Student> findByFirstName(String firstName);
  void update(Student student);
  void deleteById(int id);
  Student selectByExample(Student student);
  List<Student> getByMultipleId(List<Integer> ids);
  List<Student> findAll();
}
