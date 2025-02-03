package com.inventory.control.pro.sprgbt.domain.supplier;

/*
 */
public class SupplierDomain {

  private Long id;
  private String address;
  private String contactName;
  private String email;
  private String name;
  private String phone;

  public SupplierDomain(Long id, String address, String contactName, String email, String name,
      String phone) {
    this.id = id;
    this.address = address;
    this.contactName = contactName;
    this.email = email;
    this.name = name;
    this.phone = phone;
  }

  public Long getId() {
    return id;
  }

  public String getAddress() {
    return address;
  }

  public String getContactName() {
    return contactName;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
}
