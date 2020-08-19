package com.gotkx.productserver.model;

public class Product {

    private Long id;
    private String name;
    private Long categoryId;
    private Long brandId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Product() {
    }

    public Product(Long id, String name, Long categoryId, Long brandId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }

}
