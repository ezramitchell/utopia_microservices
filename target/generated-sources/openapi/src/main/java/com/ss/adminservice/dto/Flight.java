package com.ss.adminservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ss.adminservice.dto.Airplane;
import com.ss.adminservice.dto.Route;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Flight
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
public class Flight   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("route")
  private Route route;

  @JsonProperty("airplane")
  private Airplane airplane;

  @JsonProperty("departureTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureTime;

  @JsonProperty("reservedSeats")
  private Integer reservedSeats;

  @JsonProperty("seatPrice")
  private Float seatPrice;

  public Flight id(String id) {
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

  public Flight route(Route route) {
    this.route = route;
    return this;
  }

  /**
   * Get route
   * @return route
  */
  @ApiModelProperty(value = "")

  @Valid

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public Flight airplane(Airplane airplane) {
    this.airplane = airplane;
    return this;
  }

  /**
   * Get airplane
   * @return airplane
  */
  @ApiModelProperty(value = "")

  @Valid

  public Airplane getAirplane() {
    return airplane;
  }

  public void setAirplane(Airplane airplane) {
    this.airplane = airplane;
  }

  public Flight departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * @return departureTime
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public Flight reservedSeats(Integer reservedSeats) {
    this.reservedSeats = reservedSeats;
    return this;
  }

  /**
   * Get reservedSeats
   * @return reservedSeats
  */
  @ApiModelProperty(value = "")


  public Integer getReservedSeats() {
    return reservedSeats;
  }

  public void setReservedSeats(Integer reservedSeats) {
    this.reservedSeats = reservedSeats;
  }

  public Flight seatPrice(Float seatPrice) {
    this.seatPrice = seatPrice;
    return this;
  }

  /**
   * Get seatPrice
   * @return seatPrice
  */
  @ApiModelProperty(value = "")


  public Float getSeatPrice() {
    return seatPrice;
  }

  public void setSeatPrice(Float seatPrice) {
    this.seatPrice = seatPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(this.id, flight.id) &&
        Objects.equals(this.route, flight.route) &&
        Objects.equals(this.airplane, flight.airplane) &&
        Objects.equals(this.departureTime, flight.departureTime) &&
        Objects.equals(this.reservedSeats, flight.reservedSeats) &&
        Objects.equals(this.seatPrice, flight.seatPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, route, airplane, departureTime, reservedSeats, seatPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flight {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    route: ").append(toIndentedString(route)).append("\n");
    sb.append("    airplane: ").append(toIndentedString(airplane)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    reservedSeats: ").append(toIndentedString(reservedSeats)).append("\n");
    sb.append("    seatPrice: ").append(toIndentedString(seatPrice)).append("\n");
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

