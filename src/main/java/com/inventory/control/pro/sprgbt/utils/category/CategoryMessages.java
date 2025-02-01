package com.inventory.control.pro.sprgbt.utils.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 */
@Getter
@AllArgsConstructor
public enum CategoryMessages {

  CREATED_SUCCESS(0, "Category successfully created"),
  GET_ALL(200, "OK");

  private final int code;
  private final String message;
}
