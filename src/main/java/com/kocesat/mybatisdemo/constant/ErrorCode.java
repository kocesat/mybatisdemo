package com.kocesat.mybatisdemo.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCode {

  public static final String DEFAULT = "DEFAULT";
  public static final String DUPLICATE_GROUP = "GROUP_ALREADY_EXIST";
}
