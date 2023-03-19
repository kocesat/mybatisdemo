package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.model.Student;
import com.kocesat.mybatisdemo.model.dto.StudentCreateDto;
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
  public ResponseEntity create(@RequestBody StudentCreateDto dto) {
    studentService.create(dto);
    return ResponseEntity.ok(null);
  }

//  @GetMapping("/list")
//  public ResponseEntity<List<Student>> getAll() {
//    final var students = studentService.findAll();
//    return ResponseEntity.ok(students);
//  }

  @GetMapping("/list")
  public ResponseEntity<List<Student>> getAllWithPage(
    @RequestParam("pageNum") Integer pageNum,
    @RequestParam("pageSize") Integer pageSize
    ) {
    final var students = studentService.findAllWithPage(pageNum, pageSize);
    return ResponseEntity.ok(students);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Student> findById(@PathVariable("id") Integer id) {
    final var student = studentService.findById(id);
    return ResponseEntity.ok(student);
  }
  
  @GetMapping("/list")
  public ResponseEntity<List<Student>> findAll() {
	  return ResponseEntity.ok(studentService.findAll());
  }

  @GetMapping
  public ResponseEntity<List<Student>> findByFirstName(@RequestParam("firstName") String name) {
    final var students = studentService.findByName(name);
    return ResponseEntity.ok(students);
  }

  @SuppressWarnings("rawtypes")
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
