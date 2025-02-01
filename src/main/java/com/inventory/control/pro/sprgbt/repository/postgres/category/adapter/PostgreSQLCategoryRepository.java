package com.inventory.control.pro.sprgbt.repository.postgres.category.adapter;

import static com.inventory.control.pro.sprgbt.repository.postgres.category.ValidationUtil.validateDirection;
import static com.inventory.control.pro.sprgbt.repository.postgres.category.ValidationUtil.validatePage;
import static com.inventory.control.pro.sprgbt.repository.postgres.category.ValidationUtil.validateSize;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.category.PageDomain;
import com.inventory.control.pro.sprgbt.exception.category.CategoryException;
import com.inventory.control.pro.sprgbt.repository.postgres.category.dao.CategoryDao;
import com.inventory.control.pro.sprgbt.repository.postgres.category.mapper.CategoryMapperOutput;
import com.inventory.control.pro.sprgbt.repository.postgres.category.port.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/*
 */
@Slf4j
@Repository
@RequiredArgsConstructor
class PostgreSQLCategoryRepository implements CategoryRepository {

  private final CategoryDao categoryDao;
  private final CategoryMapperOutput categoryMapper;

  @Override
  public CategoryDomain saveCategory(CategoryDomain categoryDomain) {
    categoryDao.findByName(categoryDomain.getName().toUpperCase())
        .ifPresent(entity -> {
          log.error("This category with name {}, already exist...", entity.getName());
          throw new CategoryException();
        });
    log.info("Saving category with name {}...", categoryDomain.getName());
    return categoryMapper.toDomain(categoryDao.save(categoryMapper.toEntity(categoryDomain)));
  }

  @Override
  public CategoryDomain updateCategory(Long id, CategoryDomain categoryDomain) {
    return null;
  }

  @Override
  public PageDomain<CategoryDomain> getAllCategories(Integer page, Integer size,
      String sortDirection) {
    log.info("Init get all categories...");
    var direction = Sort.Direction.fromString(validateDirection(sortDirection));
    var pageable = PageRequest.of(validatePage(page), validateSize(size),
        Sort.by(direction, "name"));
    var entityPage = categoryDao.findAll(pageable);
    List<CategoryDomain> categoryDomainList = entityPage.getContent().stream()
        .map(categoryEntity ->
            new CategoryDomain(categoryEntity.getId(), categoryEntity.getName(),
                categoryEntity.getDescription())
        ).toList();
    return new PageDomain<>(categoryDomainList, entityPage.getNumber(), entityPage.getSize(),
        entityPage.getTotalElements(), entityPage.getTotalPages());
  }

  @Override
  public CategoryDomain getCategoryByName(String name) {
    return null;
  }
}
