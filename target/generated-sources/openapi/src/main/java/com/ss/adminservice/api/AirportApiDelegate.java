package com.ss.adminservice.api;

import com.ss.adminservice.dto.Airport;
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
 * A delegate to be called by the {@link AirportApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T10:58:43.409494-06:00[America/Denver]")
public interface AirportApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /airport : Add airport
     *
     * @param airport  (optional)
     * @return Add successful (status code 200)
     *         or Add failed (status code 400)
     * @see AirportApi#addAirport
     */
    default ResponseEntity<Void> addAirport(Airport airport) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /airport : get All airports
     *
     * @return list of airports (status code 200)
     *         or no airports/failed (status code 400)
     * @see AirportApi#getAllAirports
     */
    default ResponseEntity<List<Airport>> getAllAirports() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"iata_id\" : \"iata_id\", \"city\" : \"city\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
