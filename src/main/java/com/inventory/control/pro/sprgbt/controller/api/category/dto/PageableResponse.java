package com.inventory.control.pro.sprgbt.controller.api.category.dto;

import java.util.List;
import lombok.Builder;

/*
 */
@Builder
public record PageableResponse<T>(List<T> content, int page, int size, long totalElements,
                                  int totalPages) {

}
