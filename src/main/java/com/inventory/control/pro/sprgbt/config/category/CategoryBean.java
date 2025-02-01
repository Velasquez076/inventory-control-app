package com.inventory.control.pro.sprgbt.config.category;

import com.inventory.control.pro.sprgbt.repository.postgres.category.port.CategoryRepository;
import com.inventory.control.pro.sprgbt.service.category.port.CategoryService;
import com.inventory.control.pro.sprgbt.service.category.usecase.CategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 */
@Configuration
public class CategoryBean {

  @Bean
  public CategoryService categoryService(CategoryRepository categoryRepository) {
    return new CategoryUseCase(categoryRepository);
  }
}
