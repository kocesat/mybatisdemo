package com.kocesat.mybatisdemo.model.school.dto;

import com.kocesat.mybatisdemo.model.school.Department;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {
  private Integer id;
  private String name;

  public static DepartmentDto from(Department model) {
    return DepartmentDto.builder()
      .id(model.getId())
      .name(model.getName())
      .build();
  }
}
