package com.ss.adminservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ss.adminservice.dto.AirplaneType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Airplane
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
public class Airplane   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("airplaneType")
  private AirplaneType airplaneType;

  public Airplane id(String id) {
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

  public Airplane airplaneType(AirplaneType airplaneType) {
    this.airplaneType = airplaneType;
    return this;
  }

  /**
   * Get airplaneType
   * @return airplaneType
  */
  @ApiModelProperty(value = "")

  @Valid

  public AirplaneType getAirplaneType() {
    return airplaneType;
  }

  public void setAirplaneType(AirplaneType airplaneType) {
    this.airplaneType = airplaneType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Airplane airplane = (Airplane) o;
    return Objects.equals(this.id, airplane.id) &&
        Objects.equals(this.airplaneType, airplane.airplaneType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, airplaneType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Airplane {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    airplaneType: ").append(toIndentedString(airplaneType)).append("\n");
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

