package com.kocesat.mybatisdemo.base.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BaseException extends RuntimeException {

  private ErrorModel errorModel;
}
