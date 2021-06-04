package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class ProductTypeDTO  implements Serializable {
    private Long id;
    private String productTypeName;
    private String productTypeDescription;

    public ProductTypeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }
}
