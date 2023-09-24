package com.kocesat.mybatisdemo.model.usergroups.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {

  private Integer id;
  private String name;
  private int memberCount;
}
