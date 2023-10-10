package com.kocesat.mybatisdemo.model.school;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeePayment {

  private Integer id;
  private Student student;
  private int year;
  private int month;
  private BigDecimal amount;
}
