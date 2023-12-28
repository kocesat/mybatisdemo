package com.kocesat.mybatisdemo.base.exception;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {

  private String errorCode;
  private String errorMessage;

}
