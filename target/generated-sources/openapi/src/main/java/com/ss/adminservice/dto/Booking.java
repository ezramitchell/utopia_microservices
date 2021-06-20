package com.ss.adminservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ss.adminservice.dto.BookingPayment;
import com.ss.adminservice.dto.Flight;
import com.ss.adminservice.dto.Passenger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Booking
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
public class Booking   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("active")
  private Boolean active;

  @JsonProperty("confirmationCode")
  private String confirmationCode;

  @JsonProperty("passenger")
  private Passenger passenger;

  @JsonProperty("payment")
  private BookingPayment payment;

  @JsonProperty("flight")
  private Flight flight;

  public Booking id(String id) {
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

  public Booking active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  */
  @ApiModelProperty(value = "")


  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Booking confirmationCode(String confirmationCode) {
    this.confirmationCode = confirmationCode;
    return this;
  }

  /**
   * Get confirmationCode
   * @return confirmationCode
  */
  @ApiModelProperty(value = "")


  public String getConfirmationCode() {
    return confirmationCode;
  }

  public void setConfirmationCode(String confirmationCode) {
    this.confirmationCode = confirmationCode;
  }

  public Booking passenger(Passenger passenger) {
    this.passenger = passenger;
    return this;
  }

  /**
   * Get passenger
   * @return passenger
  */
  @ApiModelProperty(value = "")

  @Valid

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public Booking payment(BookingPayment payment) {
    this.payment = payment;
    return this;
  }

  /**
   * Get payment
   * @return payment
  */
  @ApiModelProperty(value = "")

  @Valid

  public BookingPayment getPayment() {
    return payment;
  }

  public void setPayment(BookingPayment payment) {
    this.payment = payment;
  }

  public Booking flight(Flight flight) {
    this.flight = flight;
    return this;
  }

  /**
   * Get flight
   * @return flight
  */
  @ApiModelProperty(value = "")

  @Valid

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.id, booking.id) &&
        Objects.equals(this.active, booking.active) &&
        Objects.equals(this.confirmationCode, booking.confirmationCode) &&
        Objects.equals(this.passenger, booking.passenger) &&
        Objects.equals(this.payment, booking.payment) &&
        Objects.equals(this.flight, booking.flight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, active, confirmationCode, passenger, payment, flight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    confirmationCode: ").append(toIndentedString(confirmationCode)).append("\n");
    sb.append("    passenger: ").append(toIndentedString(passenger)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    flight: ").append(toIndentedString(flight)).append("\n");
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

