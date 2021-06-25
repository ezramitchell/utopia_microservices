package com.ss.adminservice.service;

import com.ss.adminservice.api.BookingApi;
import com.ss.adminservice.api.BookingApiDelegate;
import com.ss.adminservice.dto.Booking;
import com.ss.adminservice.entity.BookingEnt;
import com.ss.adminservice.entity.FlightEnt;
import com.ss.adminservice.entity.UserEnt;
import com.ss.adminservice.jwt.JwtUtil;
import com.ss.adminservice.repo.BookingRepo;
import com.ss.adminservice.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingImpl implements BookingApiDelegate {

    private BookingRepo bookingRepo;
    private JwtUtil jwtUtil;
    private ModelMapper modelMapper;
    private UserRepo userRepo;

    public BookingImpl(BookingRepo bookingRepo, JwtUtil jwtUtil, ModelMapper modelMapper, UserRepo userRepo) {
        this.bookingRepo = bookingRepo;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    /**
     * PUT /booking
     * add booking to user
     *
     * @param authorization (required)
     * @param booking       Booking to add (required)
     * @return added (status code 200)
     * or failed (status code 400)
     * @see BookingApi#addBooking
     */
    @Override
    public ResponseEntity<Booking> addBooking(String authorization, Booking booking) {
        try {
            //get user
            Optional<UserEnt> userEnt = userRepo.findByUsername(jwtUtil.extractUsername(authorization));
            if (userEnt.isPresent() && (booking.getId() == null || !bookingRepo.existsById(UUID.fromString(booking.getId())))) {
                //map to authorized user
                booking.getUser().setId(userEnt.get().getId().toString());
                return ResponseEntity.ok(
                        convertToDTO(bookingRepo.save(convertToEntity(booking)))
                );
            }
        } catch (Exception ignored) {
        }

        return ResponseEntity.badRequest().body(null);
    }

    /**
     * POST /booking
     * cancel booking
     *
     * @param authorization (required)
     * @param booking       Booking to cancel, only id necessary (required)
     * @return succeeded (status code 200)
     * or failed (status code 400)
     * @see BookingApi#cancelBooking
     */
    @Override
    public ResponseEntity<Void> cancelBooking(String authorization, Booking booking) {
        if (booking.getId() != null && bookingRepo.existsById(UUID.fromString(booking.getId()))) {
            BookingEnt toCancel = bookingRepo.findById(UUID.fromString(booking.getId())).get();
            if (toCancel.getUser().getUsername().equals(jwtUtil.extractUsername(authorization))) {
                bookingRepo.save(toCancel.setActive(false));
                return ResponseEntity.ok(null);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /booking
     * get all bookings belonging to authenticated user
     *
     * @param authorization (required)
     * @return list of bookings (status code 200)
     * or failed (status code 400)
     * @see BookingApi#getBookings
     */
    @Override
    public ResponseEntity<List<Booking>> getBookings(String authorization) {
        try {
            List<Booking> bookings = new ArrayList<>();
            bookingRepo.findByUserId(UUID.fromString(jwtUtil.extractUsername(authorization))).forEach(
                    ent -> bookings.add(convertToDTO(ent))
            );
            return ResponseEntity.ok(bookings);
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    private BookingEnt convertToEntity(Booking b) {
        BookingEnt ent = modelMapper.map(b, BookingEnt.class);
        ent.setUser(new UserEnt().setId(UUID.fromString(b.getUser().getId())));
        ent.setFlight(new FlightEnt().setId(UUID.fromString(b.getFlight().getId())));
        return ent;
    }

    private Booking convertToDTO(BookingEnt ent) {
        Booking b = modelMapper.map(ent, Booking.class);
        b.getUser().setPassword(null);
        return b;
    }
}
