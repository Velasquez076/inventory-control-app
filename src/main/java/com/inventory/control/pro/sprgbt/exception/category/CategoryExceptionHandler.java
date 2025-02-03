package com.inventory.control.pro.sprgbt.exception.category;

import com.inventory.control.pro.sprgbt.controller.api.category.dto.WrapperResponse;
import com.inventory.control.pro.sprgbt.utils.category.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 */
@Slf4j
@RestControllerAdvice
public class CategoryExceptionHandler {

  @ExceptionHandler(value = CategoryException.class)
  ResponseEntity<WrapperResponse<Throwable>> error(CategoryException categoryException) {
    log.error("{}", categoryException.getMessage(), categoryException);
    return new ResponseEntity<>(
        new WrapperResponse<>(categoryException.getCode(),
            categoryException.getMessage(),
            categoryException.getCause()), buildStatus(categoryException.getCode()));
  }

  @ExceptionHandler(value = Exception.class)
  ResponseEntity<WrapperResponse<String>> genericError(Exception ex) {
    log.error("{}", ex.getMessage(), ex);
    return new ResponseEntity<>(
        new WrapperResponse<>(ErrorMessages.GENERIC_ERROR.getCode(),
            ErrorMessages.GENERIC_ERROR.getMessage(),
            ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private HttpStatus buildStatus(int code) {
    return HttpStatus.valueOf(code);
  }
}
