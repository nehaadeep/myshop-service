package com.senecaglobal.myshop.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.senecaglobal.myshop.models.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MyCartRequest
 */

public class MyCartRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("products")
  @Valid
  private List<Product> products = new ArrayList<Product>();

  public MyCartRequest products(List<Product> products) {
    this.products = products;
    return this;
  }

  public MyCartRequest addProductsItem(Product productsItem) {
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@Size(min=1) 
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyCartRequest myCartRequest = (MyCartRequest) o;
    return Objects.equals(this.products, myCartRequest.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyCartRequest {\n");
    
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

