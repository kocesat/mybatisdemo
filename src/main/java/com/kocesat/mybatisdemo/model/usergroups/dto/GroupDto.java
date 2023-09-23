package com.kocesat.mybatisdemo.model.usergroups.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupDto {

  private Integer id;
  private String name;
}
