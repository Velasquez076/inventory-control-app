package com.inventory.control.pro.sprgbt.service.supplier.port;

import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import com.inventory.control.pro.sprgbt.domain.supplier.SupplierDomain;

/*
 */
public interface SupplierService {

  SupplierDomain register(SupplierDomain supplierDomain);

  PageDomain<SupplierDomain> suppliers();

  SupplierDomain update(Long id, SupplierDomain supplierDomain);

  void deleteById(Long id);
}
