package com.kocesat.mybatisdemo.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends BaseException{

  public BusinessException(String errorCode) {
    super(ErrorModel.builder()
      .errorCode(errorCode)
      .build());
  }

  public BusinessException(ErrorModel errorModel) {
    super(errorModel);
  }
}
