package com.inventory.control.pro.sprgbt.controller.api.category.dto;

import lombok.Builder;

/*
 */

@Builder
public record CategoryResponse(Long id, String name, String description) {

}
