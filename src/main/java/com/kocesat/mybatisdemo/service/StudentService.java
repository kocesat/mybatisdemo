package com.kocesat.mybatisdemo.service;

import com.kocesat.mybatisdemo.model.Student;
import com.kocesat.mybatisdemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository repo;

  public void create(Student student) {
    repo.save(student);
  }

  public void testTransactional(Student student, boolean error) {
    this.create(student);
    if (error) {
      throw new RuntimeException("Transactional should cause rollback here");
    }
  }
  
  public List<Student> findAll() {
	  return repo.getAll();
  }

  public List<Student> findByName(String name) {
    return repo.findByFirstName(name);
  }

  public Student findById(Integer id) {
    final var student = repo.findById(id);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }
    return student;
  }

  public List<Student> findByMultipleId(List<Integer> idList) {
    return repo.getByMultipleId(idList);
  }
}
