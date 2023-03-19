package com.kocesat.mybatisdemo.base;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Pageable {
  private Integer limit;
  private Integer offset;
}
