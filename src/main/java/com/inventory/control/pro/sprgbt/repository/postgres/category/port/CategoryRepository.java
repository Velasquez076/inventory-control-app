package com.inventory.control.pro.sprgbt.repository.postgres.category.port;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.category.PageDomain;

/*
 */
public interface CategoryRepository {

  CategoryDomain saveCategory(CategoryDomain categoryDomain);

  CategoryDomain updateCategory(Long id, CategoryDomain categoryDomain);

  PageDomain<CategoryDomain> getAllCategories(Integer page, Integer size, String sortDirection);

  CategoryDomain getCategoryByName(String name);
}
