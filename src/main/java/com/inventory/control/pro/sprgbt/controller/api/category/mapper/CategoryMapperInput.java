package com.inventory.control.pro.sprgbt.controller.api.category.mapper;

import com.inventory.control.pro.sprgbt.controller.api.category.dto.CategoryRequest;
import com.inventory.control.pro.sprgbt.controller.api.category.dto.CategoryResponse;
import com.inventory.control.pro.sprgbt.controller.api.category.dto.PageableResponse;
import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import org.mapstruct.Mapper;

/*
 */
@Mapper(componentModel = "spring")
public interface CategoryMapperInput {

  CategoryDomain toDomain(CategoryRequest categoryRequest);

  CategoryResponse toResponse(CategoryDomain categoryDomain);

  PageableResponse<CategoryResponse> toPageableResponse(PageDomain<CategoryDomain> pageDomain);
}
