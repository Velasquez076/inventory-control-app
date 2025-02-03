package com.inventory.control.pro.sprgbt.repository.postgres.category.adapter;

import static com.inventory.control.pro.sprgbt.repository.postgres.category.util.ValidationUtil.validateDirection;
import static com.inventory.control.pro.sprgbt.repository.postgres.category.util.ValidationUtil.validatePage;
import static com.inventory.control.pro.sprgbt.repository.postgres.category.util.ValidationUtil.validateSize;

import com.inventory.control.pro.sprgbt.domain.category.CategoryDomain;
import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import com.inventory.control.pro.sprgbt.exception.category.CategoryException;
import com.inventory.control.pro.sprgbt.repository.postgres.category.dao.CategoryDao;
import com.inventory.control.pro.sprgbt.repository.postgres.category.entity.CategoryEntity;
import com.inventory.control.pro.sprgbt.repository.postgres.category.mapper.CategoryMapperOutput;
import com.inventory.control.pro.sprgbt.repository.postgres.category.port.CategoryRepository;
import com.inventory.control.pro.sprgbt.utils.category.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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

  private static final String NAME = "name";

  @Override
  public CategoryDomain saveCategory(CategoryDomain categoryDomain) {
    categoryDao.findByName(categoryDomain.getName().toUpperCase())
        .ifPresent(entity -> {
          log.error("This category with name {}, already exist...", entity.getName());
          throw new CategoryException(ErrorMessages.CATEGORY_ALREADY_EXIST.getCode(),
              String.format(ErrorMessages.CATEGORY_ALREADY_EXIST.getMessage(), entity.getName()));
        });
    log.info("Saving category with name {}...", categoryDomain.getName());
    return categoryMapper.toDomain(categoryDao.save(categoryMapper.toEntity(categoryDomain)));
  }

  @Override
  public CategoryDomain updateCategory(Long id, CategoryDomain categoryDomain) {
    return categoryDao.findById(id)
        .map(categoryEntity -> {
          categoryEntity.setName(categoryDomain.getName());
          categoryEntity.setDescription(categoryDomain.getDescription());
          return categoryMapper.toDomain(categoryDao.save(categoryEntity));
        })
        .orElseThrow(() -> new CategoryException(ErrorMessages.CATEGORY_NOT_FOUND.getCode(),
            String.format(ErrorMessages.CATEGORY_NOT_FOUND.getMessage(), id)));
  }

  @Override
  public PageDomain<CategoryDomain> getAllCategories(Integer page, Integer size,
      String sortDirection) {
    log.info("Init get all categories...");
    var direction = Sort.Direction.fromString(validateDirection(sortDirection));
    var pageable = PageRequest.of(validatePage(page), validateSize(size),
        Sort.by(direction, NAME));
    var entityPage = categoryDao.findAll(pageable);
    return buildPageDomain(entityPage);
  }

  @Override
  public CategoryDomain getCategoryByName(String name) {
    return null;
  }

  /**
   * Method build response
   *
   * @param entityPage data
   * @return
   */
  private PageDomain<CategoryDomain> buildPageDomain(Page<CategoryEntity> entityPage) {
    var categoryDomainList = entityPage.getContent().stream()
        .map(categoryEntity ->
            new CategoryDomain(categoryEntity.getId(), categoryEntity.getName(),
                categoryEntity.getDescription())
        ).toList();
    return new PageDomain<>(categoryDomainList, entityPage.getNumber(), entityPage.getSize(),
        entityPage.getTotalElements(), entityPage.getTotalPages());
  }
}
