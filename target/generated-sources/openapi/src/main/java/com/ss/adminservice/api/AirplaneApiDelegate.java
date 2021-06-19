package com.ss.adminservice.api;

import com.ss.adminservice.dto.Airplane;
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
 * A delegate to be called by the {@link AirplaneApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T12:52:51.050113-06:00[America/Denver]")
public interface AirplaneApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /airplane
     * add airplane
     *
     * @param airplane  (optional)
     * @return add successful (status code 200)
     *         or add failed (status code 400)
     * @see AirplaneApi#addAirplane
     */
    default ResponseEntity<Void> addAirplane(Airplane airplane) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /airplane/{airplaneId}
     * get airplane at id
     *
     * @param airplaneId  (required)
     * @return returns airplane (status code 200)
     * @see AirplaneApi#getAirplane
     */
    default ResponseEntity<Airplane> getAirplane(String airplaneId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"airplaneType\" : { \"maxCapacity\" : 0, \"id\" : \"id\" }, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /airplane
     * get all airplanes
     *
     * @return list of airplanes (status code 200)
     * @see AirplaneApi#getAllAirplanes
     */
    default ResponseEntity<List<Airplane>> getAllAirplanes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"airplaneType\" : { \"maxCapacity\" : 0, \"id\" : \"id\" }, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /airplane/{airplaneId}
     * update airplane
     *
     * @param airplaneId  (required)
     * @param airplane  (optional)
     * @return update succesful (status code 200)
     *         or update failed (status code 400)
     * @see AirplaneApi#updateAirplane
     */
    default ResponseEntity<Void> updateAirplane(String airplaneId,
        Airplane airplane) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
