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
 * Airport
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T10:58:43.409494-06:00[America/Denver]")
public class Airport   {
  @JsonProperty("iata_id")
  private String iataId;

  @JsonProperty("city")
  private String city;

  public Airport iataId(String iataId) {
    this.iataId = iataId;
    return this;
  }

  /**
   * Get iataId
   * @return iataId
  */
  @ApiModelProperty(value = "")


  public String getIataId() {
    return iataId;
  }

  public void setIataId(String iataId) {
    this.iataId = iataId;
  }

  public Airport city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Airport airport = (Airport) o;
    return Objects.equals(this.iataId, airport.iataId) &&
        Objects.equals(this.city, airport.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iataId, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Airport {\n");
    
    sb.append("    iataId: ").append(toIndentedString(iataId)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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

