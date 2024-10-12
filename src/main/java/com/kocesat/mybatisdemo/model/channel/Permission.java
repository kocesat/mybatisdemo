package com.kocesat.mybatisdemo.model.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

  private String code;
  private String nameTr;
  private String nameEn;
  private Integer type;
  private Integer status;
  private LocalDateTime createdAt;
  private String createdUser;
  private LocalDateTime modifiedAt;
}
