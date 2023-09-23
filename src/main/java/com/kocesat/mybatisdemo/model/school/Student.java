package com.kocesat.mybatisdemo.model.school;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
  private Integer id;
  private String firstName;
  private int age;
  private Department department;
  private Address address;
  private LocalDateTime enrolledAt;
}
