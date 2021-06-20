/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ss.adminservice.api;

import com.ss.adminservice.dto.Flight;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
@Validated
@Api(value = "flight", description = "the flight API")
public interface FlightApi {

    default FlightApiDelegate getDelegate() {
        return new FlightApiDelegate() {};
    }

    /**
     * PUT /flight : Add flight, id unnecessary
     *
     * @param flight  (optional)
     * @return Add successful (status code 200)
     *         or Add failed (status code 400)
     */
    @ApiOperation(value = "Add flight, id unnecessary", nickname = "addFlight", notes = "", response = Flight.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Add successful", response = Flight.class),
        @ApiResponse(code = 400, message = "Add failed") })
    @PutMapping(
        value = "/flight",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Flight> addFlight(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Flight flight) {
        return getDelegate().addFlight(flight);
    }


    /**
     * DELETE /flight/{flightId} : Delete flight at id
     *
     * @param flightId  (required)
     * @return Delete successful (status code 200)
     *         or Delete failed (status code 400)
     */
    @ApiOperation(value = "Delete flight at id", nickname = "deleteFlight", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Delete successful"),
        @ApiResponse(code = 400, message = "Delete failed") })
    @DeleteMapping(
        value = "/flight/{flightId}"
    )
    default ResponseEntity<Void> deleteFlight(@ApiParam(value = "",required=true) @PathVariable("flightId") String flightId) {
        return getDelegate().deleteFlight(flightId);
    }


    /**
     * GET /flight : Get all flights
     *
     * @param flightId  (required)
     * @return Read successful (status code 200)
     *         or How did you mess this up (status code 400)
     */
    @ApiOperation(value = "Get all flights", nickname = "getAllFlights", notes = "", response = Flight.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Read successful", response = Flight.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "How did you mess this up") })
    @GetMapping(
        value = "/flight",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Flight>> getAllFlights(@ApiParam(value = "",required=true) @PathVariable("flightId") String flightId) {
        return getDelegate().getAllFlights(flightId);
    }


    /**
     * GET /flight/{flightId} : Get flight at id
     *
     * @param flightId  (required)
     * @return Read successful (status code 200)
     *         or How did you mess this up (status code 400)
     */
    @ApiOperation(value = "Get flight at id", nickname = "getFlight", notes = "", response = Flight.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Read successful", response = Flight.class),
        @ApiResponse(code = 400, message = "How did you mess this up") })
    @GetMapping(
        value = "/flight/{flightId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Flight> getFlight(@ApiParam(value = "",required=true) @PathVariable("flightId") String flightId) {
        return getDelegate().getFlight(flightId);
    }


    /**
     * POST /flight/{flightId} : Update flight at id
     *
     * @param flightId  (required)
     * @param flight  (optional)
     * @return Update successful (status code 200)
     *         or Update failed (status code 400)
     */
    @ApiOperation(value = "Update flight at id", nickname = "updateFlight", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Update successful"),
        @ApiResponse(code = 400, message = "Update failed") })
    @PostMapping(
        value = "/flight/{flightId}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateFlight(@ApiParam(value = "",required=true) @PathVariable("flightId") String flightId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Flight flight) {
        return getDelegate().updateFlight(flightId, flight);
    }

}
