package com.inventory.control.pro.sprgbt.config.supplier;

import com.inventory.control.pro.sprgbt.repository.postgres.supplier.port.SupplierRepository;
import com.inventory.control.pro.sprgbt.service.supplier.port.SupplierService;
import com.inventory.control.pro.sprgbt.service.supplier.usecase.SupplierUseCase;
import org.springframework.context.annotation.Configuration;

/*
 */
@Configuration
public class SupplierBean {

  public SupplierService supplierService(SupplierRepository supplierRepository) {
    return new SupplierUseCase(supplierRepository);
  }
}
