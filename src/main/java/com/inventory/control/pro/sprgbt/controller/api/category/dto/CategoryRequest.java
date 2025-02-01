package com.inventory.control.pro.sprgbt.controller.api.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/*
 */
@Builder
public record CategoryRequest(Long id, @NotNull String name, @NotNull String description) {

}
