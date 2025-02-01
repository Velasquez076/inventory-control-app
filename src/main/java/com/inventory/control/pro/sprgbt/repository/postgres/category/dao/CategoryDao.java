package com.inventory.control.pro.sprgbt.repository.postgres.category.dao;

import com.inventory.control.pro.sprgbt.repository.postgres.category.entity.CategoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 */
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

  Optional<CategoryEntity> findByName(String name);
}
