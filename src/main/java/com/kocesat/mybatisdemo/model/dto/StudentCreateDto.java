package com.kocesat.mybatisdemo.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentCreateDto {
  String firstName;
  Integer age;
  Integer departmentId;
}
