package com.ss.adminservice.api;

import com.ss.adminservice.dto.AirplaneType;
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
 * A delegate to be called by the {@link AirplaneTypeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T22:17:56.090082400-06:00[America/Denver]")
public interface AirplaneTypeApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /airplane_type
     * add airplanetype
     *
     * @param airplaneType  (optional)
     * @return add successful (status code 200)
     *         or add failed (status code 400)
     * @see AirplaneTypeApi#addAirplaneType
     */
    default ResponseEntity<AirplaneType> addAirplaneType(AirplaneType airplaneType) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"maxCapacity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /airplane_type
     * get all airplane types
     *
     * @return list of airplane types (status code 200)
     * @see AirplaneTypeApi#getAllAirplaneTypes
     */
    default ResponseEntity<List<AirplaneType>> getAllAirplaneTypes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"maxCapacity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
