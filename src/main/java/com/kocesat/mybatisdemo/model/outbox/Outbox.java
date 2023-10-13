package com.kocesat.mybatisdemo.model.outbox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Outbox {

  private Integer id;
  private LocalDateTime insertTime;
  private LocalDateTime updateTime;
  private String data;
  private Short serviceId;
  private Short status;
}
