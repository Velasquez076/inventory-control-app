package com.inventory.control.pro.sprgbt.repository.postgres.supplier.port;

import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import com.inventory.control.pro.sprgbt.domain.supplier.SupplierDomain;

/*
 */
public interface SupplierRepository {

  SupplierDomain register(SupplierDomain supplierDomain);

  PageDomain<SupplierDomain> suppliers();

  SupplierDomain update(Long id, SupplierDomain supplierDomain);

  void deleteById(Long id);
}
