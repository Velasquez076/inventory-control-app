package com.inventory.control.pro.sprgbt.domain.category;

/*
 */
public class CategoryDomain {

  private Long id;
  private String name;
  private String description;

  public CategoryDomain(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "CategoryDomain{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
