package com.kocesat.mybatisdemo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppUtil {

  public static <T> T ifNull(T obj, T defaultObj) {
    return Objects.requireNonNullElse(obj, defaultObj);
  }
}
