/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ss.adminservice.api;

import com.ss.adminservice.dto.AirplaneType;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-20T15:45:31.821814900-06:00[America/Denver]")
@Validated
@Api(value = "airplane_type", description = "the airplane_type API")
public interface AirplaneTypeApi {

    default AirplaneTypeApiDelegate getDelegate() {
        return new AirplaneTypeApiDelegate() {};
    }

    /**
     * PUT /airplane_type
     * add airplanetype
     *
     * @param airplaneType  (optional)
     * @return add successful (status code 200)
     *         or add failed (status code 400)
     */
    @ApiOperation(value = "", nickname = "addAirplaneType", notes = "add airplanetype", response = AirplaneType.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "add successful", response = AirplaneType.class),
        @ApiResponse(code = 400, message = "add failed") })
    @PutMapping(
        value = "/airplane_type",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AirplaneType> addAirplaneType(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) AirplaneType airplaneType) {
        return getDelegate().addAirplaneType(airplaneType);
    }


    /**
     * GET /airplane_type
     * get all airplane types
     *
     * @return list of airplane types (status code 200)
     */
    @ApiOperation(value = "", nickname = "getAllAirplaneTypes", notes = "get all airplane types", response = AirplaneType.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of airplane types", response = AirplaneType.class, responseContainer = "List") })
    @GetMapping(
        value = "/airplane_type",
        produces = { "application/json" }
    )
    default ResponseEntity<List<AirplaneType>> getAllAirplaneTypes() {
        return getDelegate().getAllAirplaneTypes();
    }

}
