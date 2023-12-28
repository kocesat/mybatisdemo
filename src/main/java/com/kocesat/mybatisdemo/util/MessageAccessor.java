package com.kocesat.mybatisdemo.util;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageAccessor {
  private static final String DEFAULT_ERROR_KEY = "DEFAULT";
  private static final String DEFAULT_ERROR_MSG = "We're out of service for now. Please try again later";
  private static MessageSource messageSource;

  public MessageAccessor(MessageSource messageSource) {
    MessageAccessor.messageSource = messageSource;
  }

  public static String getMessage(String key, Locale locale) {
    if (key == null) {
      key = DEFAULT_ERROR_KEY;
    }
    try {
      return messageSource.getMessage(key, new Object[0], locale);
    } catch (NoSuchMessageException e) {
      return DEFAULT_ERROR_MSG;
    }
  }
}
