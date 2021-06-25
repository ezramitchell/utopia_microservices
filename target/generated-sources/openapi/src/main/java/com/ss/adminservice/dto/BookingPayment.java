package com.ss.adminservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookingPayment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-24T19:10:03.915280200-06:00[America/Denver]")
public class BookingPayment   {
  @JsonProperty("stripeId")
  private String stripeId;

  @JsonProperty("refunded")
  private Boolean refunded;

  public BookingPayment stripeId(String stripeId) {
    this.stripeId = stripeId;
    return this;
  }

  /**
   * Get stripeId
   * @return stripeId
  */
  @ApiModelProperty(value = "")


  public String getStripeId() {
    return stripeId;
  }

  public void setStripeId(String stripeId) {
    this.stripeId = stripeId;
  }

  public BookingPayment refunded(Boolean refunded) {
    this.refunded = refunded;
    return this;
  }

  /**
   * Get refunded
   * @return refunded
  */
  @ApiModelProperty(value = "")


  public Boolean getRefunded() {
    return refunded;
  }

  public void setRefunded(Boolean refunded) {
    this.refunded = refunded;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingPayment bookingPayment = (BookingPayment) o;
    return Objects.equals(this.stripeId, bookingPayment.stripeId) &&
        Objects.equals(this.refunded, bookingPayment.refunded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stripeId, refunded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingPayment {\n");
    
    sb.append("    stripeId: ").append(toIndentedString(stripeId)).append("\n");
    sb.append("    refunded: ").append(toIndentedString(refunded)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

