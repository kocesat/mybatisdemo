package com.kocesat.mybatisdemo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppUtil {

  public static <T> T ifNull(T obj, T defaultObj) {
    return obj == null ? defaultObj : obj;
  }
}
