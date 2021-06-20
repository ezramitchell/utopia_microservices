/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ss.adminservice.api;

import com.ss.adminservice.dto.Airport;
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
@Api(value = "airport", description = "the airport API")
public interface AirportApi {

    default AirportApiDelegate getDelegate() {
        return new AirportApiDelegate() {};
    }

    /**
     * PUT /airport : Add airport
     *
     * @param airport  (optional)
     * @return Add successful (status code 200)
     *         or Add failed (status code 400)
     */
    @ApiOperation(value = "Add airport", nickname = "addAirport", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Add successful"),
        @ApiResponse(code = 400, message = "Add failed") })
    @PutMapping(
        value = "/airport",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> addAirport(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Airport airport) {
        return getDelegate().addAirport(airport);
    }


    /**
     * DELETE /airport/{iataId}
     * Delete airport
     *
     * @param iataId  (required)
     * @return Delete succeeded (status code 200)
     *         or Delete failed (status code 400)
     */
    @ApiOperation(value = "", nickname = "deleteAirport", notes = "Delete airport", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Delete succeeded"),
        @ApiResponse(code = 400, message = "Delete failed") })
    @DeleteMapping(
        value = "/airport/{iataId}"
    )
    default ResponseEntity<Void> deleteAirport(@ApiParam(value = "",required=true) @PathVariable("iataId") String iataId) {
        return getDelegate().deleteAirport(iataId);
    }


    /**
     * GET /airport : get All airports
     *
     * @return list of airports (status code 200)
     *         or no airports/failed (status code 400)
     */
    @ApiOperation(value = "get All airports", nickname = "getAllAirports", notes = "", response = Airport.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of airports", response = Airport.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "no airports/failed") })
    @GetMapping(
        value = "/airport",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Airport>> getAllAirports() {
        return getDelegate().getAllAirports();
    }

}
