package com.kocesat.mybatisdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
  private Integer id;
  private String address;
}
