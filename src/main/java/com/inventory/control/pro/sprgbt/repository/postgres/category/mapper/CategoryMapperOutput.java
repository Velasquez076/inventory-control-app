package com.inventory.control.pro.sprgbt.repository.postgres.category.mapper;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.repository.postgres.category.entity.CategoryEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/*
 */
@Mapper(componentModel = "spring")
public interface CategoryMapperOutput {

  @Mapping(source = "name", target = "name", qualifiedByName = "toUpperCase")
  CategoryEntity toEntity(CategoryDomain categoryDomain);

  CategoryDomain toDomain(CategoryEntity categoryEntity);

  List<CategoryDomain> toCategoryDomainList(List<CategoryEntity> categoryEntityList);

  @Named("toUpperCase")
  default String toUpperCase(String value) {
    return value != null ? value.toUpperCase() : null;
  }
}
