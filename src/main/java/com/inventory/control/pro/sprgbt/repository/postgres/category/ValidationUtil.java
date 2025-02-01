package com.inventory.control.pro.sprgbt.repository.postgres.category;

import com.inventory.control.pro.sprgbt.utils.category.Direction;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtil {

  public static String validateDirection(String value) {
    if (Objects.nonNull(value) && (value.equalsIgnoreCase(Direction.DESC.name())
        || value.equalsIgnoreCase(Direction.ASC.name()))) {
      log.info("Direction sorted is: {}", value);
      return value;
    }
    return Direction.ASC.name();
  }

  public static Integer validatePage(Integer page) {
    return (Objects.nonNull(page)) ? page : 0;
  }

  public static Integer validateSize(Integer size) {
    return (Objects.nonNull(size)) ? size : 10;
  }
}
