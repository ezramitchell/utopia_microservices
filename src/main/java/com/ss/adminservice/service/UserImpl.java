package com.ss.adminservice.service;

import com.ss.adminservice.api.BookingApi;
import com.ss.adminservice.api.BookingApiDelegate;
import com.ss.adminservice.api.UserApi;
import com.ss.adminservice.api.UserApiDelegate;
import com.ss.adminservice.dto.Booking;
import com.ss.adminservice.dto.BookingPayment;
import com.ss.adminservice.dto.Passenger;
import com.ss.adminservice.dto.User;
import com.ss.adminservice.entity.*;
import com.ss.adminservice.repo.BookingRepo;
import com.ss.adminservice.repo.UserRepo;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserImpl implements UserApiDelegate, BookingApiDelegate {

    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder bcrypt;

    public UserImpl(BookingRepo bookingRepo, UserRepo userRepo, ModelMapper modelMapper, PasswordEncoder bcrypt) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.bcrypt = bcrypt;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UserApiDelegate.super.getRequest();
    }

    /**
     * PUT /user/{userId}/booking : Added new booking
     *
     * @param userId  (required)
     * @param booking (optional)
     * @return Add successful (status code 200)
     * or Add failed (status code 400)
     * @see UserApi#addBooking
     */
    @Override
    public ResponseEntity<Booking> addBooking(String userId, Booking booking) {
        if (userRepo.existsById(UUID.fromString(userId))) {
            try {
                booking.getUser().setId(userId);
                return ResponseEntity.ok(
                        convertToDTO(bookingRepo.save(convertToEntity(booking)))
                );
            } catch (Exception ignored) {
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * PUT /user : Create new user
     *
     * @param user (optional)
     * @return User created (status code 200)
     * or Delete failed (status code 400)
     * @see UserApi#addUser
     */
    @Override
    public ResponseEntity<User> addUser(User user) {
        if (!userRepo.existsById(UUID.fromString(user.getId()))) {
            try {
                return ResponseEntity.ok(
                        convertToDTO(userRepo.save(
                                convertToEntity(user).setPassword(bcrypt.encode(user.getPassword()))
                        )));
            } catch (Exception ignored) {
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * DELETE /user/{userId} : Deletes user at id
     *
     * @param userId (required)
     * @return ok (status code 200)
     * or Delete failed (status code 400)
     * @see UserApi#deleteUser
     */
    @Override
    public ResponseEntity<Void> deleteUser(String userId) {
        try {
            userRepo.deleteById(UUID.fromString(userId));
            return ResponseEntity.ok(null);
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /user/{userId} : Returns user at Id
     *
     * @param userId (required)
     * @return ok (status code 200)
     * or No user at id (status code 404)
     * @see UserApi#getUser
     */
    @Override
    public ResponseEntity<User> getUser(String userId) {
        try {
            Optional<UserEnt> ent = userRepo.findById(UUID.fromString(userId));
            if (ent.isPresent())
                return ResponseEntity.ok(convertToDTO(ent.get()));
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /user/{userId}/booking : Get users bookings
     *
     * @param userId (required)
     * @return Returns list of users bookings (status code 200)
     * or No user at id (status code 404)
     * @see UserApi#getUserBookings
     */
    @Override
    public ResponseEntity<List<Booking>> getUserBookings(String userId) {
        if (userRepo.existsById(UUID.fromString(userId))) {
            try {
                List<Booking> list = new ArrayList<>();
                bookingRepo.findByUserId(
                        UUID.fromString(userId)).forEach(ent -> list.add(convertToDTO(ent)));
                return new ResponseEntity<>(list, HttpStatus.OK);
            } catch (Exception ignored) {
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * POST /user/{userId}/booking : Update booking, booking id necessary
     *
     * @param userId  (required)
     * @param booking (optional)
     * @return Update successful (status code 200)
     * or Update failed (status code 400)
     * @see UserApi#updateBooking
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public ResponseEntity<Void> updateBooking(String userId, Booking booking) {
        //check for user
        if (userRepo.existsById(UUID.fromString(userId)) && userId.equals(booking.getUser().getId())) {
            try {
                Optional<BookingEnt> original = bookingRepo.findById(UUID.fromString(booking.getId()));
                if (original.isPresent()) {
                    BookingEnt newBooking = original.get();
                    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
                    modelMapper.map(convertToEntity(booking), newBooking);
                    bookingRepo.save(newBooking);
                }
            } catch (Exception ignored) {
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * POST /user : Update user
     * Id necessary, any other non null properties will be updated
     *
     * @param user (optional)
     * @return Update succeeded (status code 200)
     * or Update failed (status code 400)
     * @see UserApi#updateUser
     */
    @Override
    public ResponseEntity<Void> updateUser(User user) {
        try {
            Optional<UserEnt> optional = userRepo.findById(UUID.fromString(user.getId()));
            if (optional.isPresent()) {
                UserEnt original = optional.get();
                modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
                modelMapper.map(convertToEntity(user), original);
                original.setPassword(bcrypt.encode(user.getPassword()));
                userRepo.save(original);
            }
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /booking : Returns all bookings
     *
     * @return list of bookings (status code 200)
     * or Somethings wrong (status code 400)
     * @see BookingApi#getAllBookings
     */
    @Override
    public ResponseEntity<List<Booking>> getAllBookings() {
        try {
            List<Booking> list = new ArrayList<>();
            bookingRepo.findAll().forEach(ent -> list.add(convertToDTO(ent)));
            return ResponseEntity.ok(list);
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    private BookingEnt convertToEntity(Booking b) {
        BookingEnt ent = modelMapper.map(b, BookingEnt.class);
        ent.setUser(new UserEnt().setId(UUID.fromString(b.getUser().getId())));
        ent.setFlight(new FlightEnt().setId(UUID.fromString(b.getFlight().getId())));
        ent.setPassenger(modelMapper.map(b.getPassenger(), PassengerEnt.class));
        ent.setPayment(modelMapper.map(b.getPayment(), BookingPaymentEnt.class));
        return ent;
    }

    private Booking convertToDTO(BookingEnt ent) {
        Booking b = modelMapper.map(ent, Booking.class);
        b.setPassenger(modelMapper.map(ent.getPassenger(), Passenger.class));
        b.setPayment(modelMapper.map(ent.getPayment(), BookingPayment.class));
        return b;
    }

    private UserEnt convertToEntity(User u) {
        return modelMapper.map(u, UserEnt.class);
    }

    private User convertToDTO(UserEnt ent) {
        User u = modelMapper.map(ent, User.class);
        u.setPassword(null);
        return u;
    }
}
