package com.inventory.control.pro.sprgbt.repository.postgres.supplier.adapter;

import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import com.inventory.control.pro.sprgbt.domain.supplier.SupplierDomain;
import com.inventory.control.pro.sprgbt.repository.postgres.supplier.dao.SupplierDao;
import com.inventory.control.pro.sprgbt.repository.postgres.supplier.port.SupplierRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/*
 */
@Slf4j
@Repository
@RequiredArgsConstructor
class PostgreSQLSupplierRepository implements SupplierRepository {

  private final SupplierDao supplierDao;

  @Override
  public SupplierDomain register(SupplierDomain supplierDomain) {
    return null;
  }

  @Override
  public PageDomain<SupplierDomain> suppliers() {
    return null;
  }

  @Override
  public SupplierDomain update(Long id, SupplierDomain supplierDomain) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }
}
