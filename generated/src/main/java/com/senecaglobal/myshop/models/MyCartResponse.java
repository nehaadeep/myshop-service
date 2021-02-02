package com.senecaglobal.myshop.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MyCartResponse
 */

public class MyCartResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("subtotal")
  private Double subtotal;

  @JsonProperty("tax")
  private Double tax;

  @JsonProperty("total")
  private Double total;

  @JsonProperty("comments")
  private String comments;

  @JsonProperty("discounts")
  @Valid
  private List<String> discounts = null;

  public MyCartResponse subtotal(Double subtotal) {
    this.subtotal = subtotal;
    return this;
  }

  /**
   * Get subtotal
   * @return subtotal
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

  public MyCartResponse tax(Double tax) {
    this.tax = tax;
    return this;
  }

  /**
   * Get tax
   * @return tax
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getTax() {
    return tax;
  }

  public void setTax(Double tax) {
    this.tax = tax;
  }

  public MyCartResponse total(Double total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public MyCartResponse comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Get comments
   * @return comments
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public MyCartResponse discounts(List<String> discounts) {
    this.discounts = discounts;
    return this;
  }

  public MyCartResponse addDiscountsItem(String discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<String>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * Get discounts
   * @return discounts
  */
  @ApiModelProperty(value = "")


  public List<String> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<String> discounts) {
    this.discounts = discounts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyCartResponse myCartResponse = (MyCartResponse) o;
    return Objects.equals(this.subtotal, myCartResponse.subtotal) &&
        Objects.equals(this.tax, myCartResponse.tax) &&
        Objects.equals(this.total, myCartResponse.total) &&
        Objects.equals(this.comments, myCartResponse.comments) &&
        Objects.equals(this.discounts, myCartResponse.discounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subtotal, tax, total, comments, discounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyCartResponse {\n");
    
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
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

