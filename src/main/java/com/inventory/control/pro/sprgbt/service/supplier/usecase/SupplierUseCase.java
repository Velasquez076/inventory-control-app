package com.inventory.control.pro.sprgbt.service.supplier.usecase;

import com.inventory.control.pro.sprgbt.domain.general.PageDomain;
import com.inventory.control.pro.sprgbt.domain.supplier.SupplierDomain;
import com.inventory.control.pro.sprgbt.repository.postgres.supplier.port.SupplierRepository;
import com.inventory.control.pro.sprgbt.service.supplier.port.SupplierService;

/*
 */
public class SupplierUseCase implements SupplierService {

  private final SupplierRepository supplierRepository;

  public SupplierUseCase(SupplierRepository supplierRepository) {
    this.supplierRepository = supplierRepository;
  }

  @Override
  public SupplierDomain register(SupplierDomain supplierDomain) {
    return supplierRepository.register(supplierDomain);
  }

  @Override
  public PageDomain<SupplierDomain> suppliers() {
    return supplierRepository.suppliers();
  }

  @Override
  public SupplierDomain update(Long id, SupplierDomain supplierDomain) {
    return supplierRepository.update(id, supplierDomain);
  }

  @Override
  public void deleteById(Long id) {
    supplierRepository.deleteById(id);
  }
}
