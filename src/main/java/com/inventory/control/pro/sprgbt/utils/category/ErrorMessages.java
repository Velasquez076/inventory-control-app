package com.inventory.control.pro.sprgbt.utils.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 */
@Getter
@AllArgsConstructor
public enum ErrorMessages {

  CATEGORY_ALREADY_EXIST(400, "ERR_001:CATEGORY ALREADY EXIST"),
  GENERIC_ERROR(555, "ERR_500:UNEXPECTED ERROR");

  private final int code;
  private final String message;
}
