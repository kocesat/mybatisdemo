package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.model.Student;
import com.kocesat.mybatisdemo.model.dto.StudentIdListWrapper;
import com.kocesat.mybatisdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public ResponseEntity create(@RequestBody Student student) {
    studentService.create(student);
    return ResponseEntity.ok(null);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> findById(@PathVariable("id") Integer id) {
    final var student = studentService.findById(id);
    return ResponseEntity.ok(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> findByFirstName(@RequestParam("firstName") String name) {
    final var students = studentService.findByName(name);
    return ResponseEntity.ok(students);
  }

  @PostMapping("/transactional-test")
  public ResponseEntity testTransactional(@RequestBody Student student, @RequestParam("error") boolean error) {
    studentService.testTransactional(student, error);
    return ResponseEntity.ok(null);
  }

  @PostMapping("/multiple-id")
  public ResponseEntity<List<Student>> findByMultipleId(@RequestBody StudentIdListWrapper idListWrapper) {
    List<Student> students = studentService.findByMultipleId(idListWrapper.getIdList());
    return ResponseEntity.ok(students);
  }

}
