package com.kocesat.mybatisdemo.repo.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlagDto {

  private Integer customerId;
  private Integer companyId;
  private String flagName;
  private boolean flag;
}
