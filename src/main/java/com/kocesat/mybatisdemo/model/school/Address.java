package com.kocesat.mybatisdemo.model.school;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
  private Integer id;
  private String address;
}
