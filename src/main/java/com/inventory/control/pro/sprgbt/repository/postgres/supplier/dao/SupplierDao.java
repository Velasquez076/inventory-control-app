package com.inventory.control.pro.sprgbt.repository.postgres.supplier.dao;

import com.inventory.control.pro.sprgbt.repository.postgres.supplier.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 */
public interface SupplierDao extends JpaRepository<SupplierEntity, Long> {

}
