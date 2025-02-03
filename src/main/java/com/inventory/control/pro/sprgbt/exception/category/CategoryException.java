package com.inventory.control.pro.sprgbt.exception.category;

import lombok.Getter;

/*
 */
@Getter
public class CategoryException extends RuntimeException {

  private final String message;
  private final int code;

  public CategoryException(int code, String message) {
    super(message);
    this.message = message;
    this.code = code;
  }
}
