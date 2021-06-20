package com.ss.adminservice.api;

import com.ss.adminservice.dto.Booking;
import com.ss.adminservice.dto.User;
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
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T22:17:56.090082400-06:00[America/Denver]")
public interface UserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /user/{userId}/booking : Added new booking
     *
     * @param userId  (required)
     * @param booking  (optional)
     * @return Add successful (status code 200)
     *         or Add failed (status code 400)
     * @see UserApi#addBooking
     */
    default ResponseEntity<Booking> addBooking(String userId,
        Booking booking) {
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

    /**
     * PUT /user : Create new user
     *
     * @param user  (optional)
     * @return User created (status code 200)
     *         or Delete failed (status code 400)
     * @see UserApi#addUser
     */
    default ResponseEntity<User> addUser(User user) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastName\" : \"lastName\", \"firstName\" : \"firstName\", \"password\" : \"password\", \"phone\" : \"phone\", \"id\" : \"id\", \"userRole\" : \"userRole\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /user/{userId} : Deletes user at id
     *
     * @param userId  (required)
     * @return ok (status code 200)
     *         or Delete failed (status code 400)
     * @see UserApi#deleteUser
     */
    default ResponseEntity<Void> deleteUser(String userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /user/{userId} : Returns user at Id
     *
     * @param userId  (required)
     * @return ok (status code 200)
     *         or No user at id (status code 404)
     * @see UserApi#getUser
     */
    default ResponseEntity<User> getUser(Integer userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastName\" : \"lastName\", \"firstName\" : \"firstName\", \"password\" : \"password\", \"phone\" : \"phone\", \"id\" : \"id\", \"userRole\" : \"userRole\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /user/{userId}/booking : Get users bookings
     *
     * @param userId  (required)
     * @return Returns list of users bookings (status code 200)
     *         or No user at id (status code 404)
     * @see UserApi#getUserBookings
     */
    default ResponseEntity<List<Booking>> getUserBookings(String userId) {
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

    /**
     * POST /user/{userId}/booking : Update booking, booking id necessary
     *
     * @param userId  (required)
     * @param booking  (optional)
     * @return Update successful (status code 200)
     *         or Update failed (status code 400)
     * @see UserApi#updateBooking
     */
    default ResponseEntity<Void> updateBooking(Integer userId,
        Booking booking) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /user : Update user
     * Id necessary, any other non null properties will be updated
     *
     * @param user  (optional)
     * @return Update succeeded (status code 200)
     *         or Update failed (status code 400)
     * @see UserApi#updateUser
     */
    default ResponseEntity<Void> updateUser(User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
