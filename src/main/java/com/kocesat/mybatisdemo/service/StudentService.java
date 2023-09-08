package com.kocesat.mybatisdemo.service;

import com.kocesat.mybatisdemo.base.Pageable;
import com.kocesat.mybatisdemo.constant.AppConstant;
import com.kocesat.mybatisdemo.model.Department;
import com.kocesat.mybatisdemo.model.Student;
import com.kocesat.mybatisdemo.model.dto.StudentCreateDto;
import com.kocesat.mybatisdemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final DepartmentService departmentService;

  @Transactional
  public Student create(StudentCreateDto dto) {
    final Department department = departmentService.findById(dto.getDepartmentId());
    final Student student = Student.builder()
      .age(dto.getAge())
      .firstName(dto.getFirstName())
      .department(department)
      .enrolledAt(LocalDateTime.now(ZoneId.of(AppConstant.TR_ZONE)))
      .build();
    studentRepository.save(student);
    return student;
  }

  public void testTransactional(Student student, boolean error) {
    studentRepository.save(student);
    if (error) {
      throw new RuntimeException("Transactional should cause rollback here");
    }
  }

  public List<Student> findByName(String name) {
    return studentRepository.findByFirstName(name);
  }

  public Student findById(Integer id) {
    final var student = studentRepository.findById(id);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }
    return student;
  }

  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  public List<Student> findAllWithPage(Integer pageNum, Integer pageSize) {
    int limit = pageSize == null ? 10000 : pageSize;
    int offset = pageNum == null ? 1 : (pageNum - 1) * limit;
    final Pageable pageable = Pageable.builder()
      .limit(limit)
      .offset(offset)
      .build();
    return studentRepository.findAllWithPage(pageable);
  }

  public List<Student> findByMultipleId(List<Integer> idList) {
    return studentRepository.getByMultipleId(idList);
  }
}
