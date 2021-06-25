package com.ss.adminservice.api;

import com.ss.adminservice.dto.Flight;
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
 * A delegate to be called by the {@link FlightApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-24T19:25:38.654864600-06:00[America/Denver]")
public interface FlightApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /flight
     * get all flights
     *
     * @param authorization  (required)
     * @return list of flights (status code 200)
     *         or failed (status code 400)
     * @see FlightApi#getAllFlights
     */
    default ResponseEntity<List<Flight>> getAllFlights(String authorization) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"departureTime\" : \"2000-01-23T04:56:07.000+00:00\", \"reservedSeats\" : 6, \"route\" : { \"originAirport\" : { \"city\" : \"city\", \"iataId\" : \"iataId\" }, \"id\" : \"id\", \"destinationAirport\" : { \"city\" : \"city\", \"iataId\" : \"iataId\" } }, \"airplane\" : { \"airplaneType\" : { \"maxCapacity\" : 0, \"id\" : \"id\" }, \"id\" : \"id\" }, \"id\" : \"id\", \"seatPrice\" : 1.4658129 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
