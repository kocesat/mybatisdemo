package com.kocesat.mybatisdemo.base.web;

import com.kocesat.mybatisdemo.base.exception.BaseException;
import com.kocesat.mybatisdemo.base.exception.ErrorModel;
import com.kocesat.mybatisdemo.constant.ErrorCode;
import com.kocesat.mybatisdemo.util.MessageAccessor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.annotation.Annotation;
import java.util.Locale;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorModel> handleBaseException(BaseException e) {
    final ErrorModel errorModel = e.getErrorModel();
    Annotation[] annotations = e.getClass().getAnnotations();
    int httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    for (Annotation annotation : annotations) {
      if (annotation.annotationType() == ResponseStatus.class) {
        HttpStatus httpStatus = ((ResponseStatus) annotation).value();
        if (httpStatus != null) {
          httpStatusCode = httpStatus.value();
        }
      }
    }
    if (errorModel.getErrorCode() == null) {
      errorModel.setErrorCode("DEFAULT");
    }
    if (errorModel.getErrorMessage() == null) {
      Locale locale = LocaleContextHolder.getLocale();
      final String errorCode = errorModel.getErrorCode();
      String localizedMsg = MessageAccessor.getMessage(errorCode, locale);
      errorModel.setErrorMessage(localizedMsg);
    }
    return ResponseEntity.status(httpStatusCode).body(errorModel);
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ErrorModel> handleUnhandledException(Throwable t) {
    final ErrorModel errorModel = ErrorModel.builder()
      .errorCode(null)
      .errorMessage(MessageAccessor.getMessage(ErrorCode.DEFAULT, LocaleContextHolder.getLocale()))
      .build();
    return ResponseEntity.internalServerError().body(errorModel);
  }
}
