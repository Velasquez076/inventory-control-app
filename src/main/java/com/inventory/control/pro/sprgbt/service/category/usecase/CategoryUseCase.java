package com.inventory.control.pro.sprgbt.service.category.usecase;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.category.PageDomain;
import com.inventory.control.pro.sprgbt.repository.postgres.category.port.CategoryRepository;
import com.inventory.control.pro.sprgbt.service.category.port.CategoryService;

/*
 */
public class CategoryUseCase implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryUseCase(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public CategoryDomain saveCategory(CategoryDomain categoryDomain) {
    return categoryRepository.saveCategory(categoryDomain);
  }

  @Override
  public CategoryDomain updateCategory(Long id, CategoryDomain categoryDomain) {
    return categoryRepository.updateCategory(id, categoryDomain);
  }

  @Override
  public PageDomain<CategoryDomain> getAllCategories(Integer page, Integer size,
      String sortDirection) {
    return categoryRepository.getAllCategories(page, size, sortDirection);
  }

  @Override
  public CategoryDomain getCategoryByName(String name) {
    return categoryRepository.getCategoryByName(name);
  }
}
