package com.inventory.control.pro.sprgbt.service.category.port;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.general.PageDomain;

/*
 */
public interface CategoryService {

  CategoryDomain saveCategory(CategoryDomain categoryDomain);

  CategoryDomain updateCategory(Long id, CategoryDomain categoryDomain);

  PageDomain<CategoryDomain> getAllCategories(Integer page, Integer size, String sortDirection);

  CategoryDomain getCategoryByName(String name);
}
