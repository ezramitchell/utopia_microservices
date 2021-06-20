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
 * AirplaneType
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
public class AirplaneType   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("maxCapacity")
  private Integer maxCapacity;

  public AirplaneType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * UUID
   * @return id
  */
  @ApiModelProperty(value = "UUID")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AirplaneType maxCapacity(Integer maxCapacity) {
    this.maxCapacity = maxCapacity;
    return this;
  }

  /**
   * Get maxCapacity
   * @return maxCapacity
  */
  @ApiModelProperty(value = "")


  public Integer getMaxCapacity() {
    return maxCapacity;
  }

  public void setMaxCapacity(Integer maxCapacity) {
    this.maxCapacity = maxCapacity;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AirplaneType airplaneType = (AirplaneType) o;
    return Objects.equals(this.id, airplaneType.id) &&
        Objects.equals(this.maxCapacity, airplaneType.maxCapacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, maxCapacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AirplaneType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    maxCapacity: ").append(toIndentedString(maxCapacity)).append("\n");
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

