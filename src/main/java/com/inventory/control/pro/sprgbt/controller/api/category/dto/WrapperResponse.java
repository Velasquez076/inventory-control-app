package com.inventory.control.pro.sprgbt.controller.api.category.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

/*
 */
@Builder
public record WrapperResponse<T>(int responseCode, String responseDescription,
                                 @JsonInclude(Include.NON_NULL) T responseContent) {

}
