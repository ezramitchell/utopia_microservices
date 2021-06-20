package com.ss.adminservice.api;

import com.ss.adminservice.dto.Booking;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link BookingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T22:17:56.090082400-06:00[America/Denver]")
public interface BookingApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /booking : Returns all bookings
     *
     * @return list of bookings (status code 200)
     *         or Somethings wrong (status code 400)
     * @see BookingApi#getAllBookings
     */
    default ResponseEntity<List<Booking>> getAllBookings() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"confirmationCode\" : \"confirmationCode\", \"flight\" : { \"departureTime\" : \"2000-01-23T04:56:07.000+00:00\", \"reservedSeats\" : 6, \"route\" : { \"originAirport\" : { \"city\" : \"city\", \"iataId\" : \"iataId\" }, \"id\" : \"id\", \"destinationAirport\" : { \"city\" : \"city\", \"iataId\" : \"iataId\" } }, \"airplane\" : { \"airplaneType\" : { \"maxCapacity\" : 0, \"id\" : \"id\" }, \"id\" : \"id\" }, \"id\" : \"id\", \"seatPrice\" : 1.4658129 }, \"passenger\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"address\" : \"address\", \"gender\" : \"gender\" }, \"active\" : true, \"payment\" : { \"stripeId\" : \"stripeId\", \"refunded\" : true }, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
