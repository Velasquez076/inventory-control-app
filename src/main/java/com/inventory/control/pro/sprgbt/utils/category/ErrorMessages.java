package com.inventory.control.pro.sprgbt.utils.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 */
@Getter
@AllArgsConstructor
public enum ErrorMessages {

  CATEGORY_ALREADY_EXIST(400, "ERR_001:CATEGORY '%s' ALREADY EXIST"),
  CATEGORY_NOT_FOUND(404, "ERR_002:CATEGORY NOT FOUND ID::  %s"),
  GENERIC_ERROR(555, "ERR_500:UNEXPECTED ERROR");

  private final int code;
  private final String message;
}
