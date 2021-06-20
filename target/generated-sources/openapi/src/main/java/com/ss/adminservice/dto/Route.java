package com.ss.adminservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ss.adminservice.dto.Airport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Route
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T22:17:56.090082400-06:00[America/Denver]")
public class Route   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("originAirport")
  private Airport originAirport;

  @JsonProperty("destinationAirport")
  private Airport destinationAirport;

  public Route id(String id) {
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

  public Route originAirport(Airport originAirport) {
    this.originAirport = originAirport;
    return this;
  }

  /**
   * Get originAirport
   * @return originAirport
  */
  @ApiModelProperty(value = "")

  @Valid

  public Airport getOriginAirport() {
    return originAirport;
  }

  public void setOriginAirport(Airport originAirport) {
    this.originAirport = originAirport;
  }

  public Route destinationAirport(Airport destinationAirport) {
    this.destinationAirport = destinationAirport;
    return this;
  }

  /**
   * Get destinationAirport
   * @return destinationAirport
  */
  @ApiModelProperty(value = "")

  @Valid

  public Airport getDestinationAirport() {
    return destinationAirport;
  }

  public void setDestinationAirport(Airport destinationAirport) {
    this.destinationAirport = destinationAirport;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.id, route.id) &&
        Objects.equals(this.originAirport, route.originAirport) &&
        Objects.equals(this.destinationAirport, route.destinationAirport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, originAirport, destinationAirport);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    originAirport: ").append(toIndentedString(originAirport)).append("\n");
    sb.append("    destinationAirport: ").append(toIndentedString(destinationAirport)).append("\n");
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

