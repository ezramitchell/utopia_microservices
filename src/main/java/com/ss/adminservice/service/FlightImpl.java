package com.ss.adminservice.service;

import com.ss.adminservice.api.FlightApi;
import com.ss.adminservice.api.FlightApiDelegate;
import com.ss.adminservice.dto.Airplane;
import com.ss.adminservice.dto.Flight;
import com.ss.adminservice.dto.Route;
import com.ss.adminservice.entity.AirplaneEnt;
import com.ss.adminservice.entity.FlightEnt;
import com.ss.adminservice.entity.RouteEnt;
import com.ss.adminservice.repo.FlightRepo;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightImpl implements FlightApiDelegate {

    private final FlightRepo flightRepo;
    private final ModelMapper modelMapper;

    public FlightImpl(FlightRepo flightRepo, ModelMapper modelMapper) {
        this.flightRepo = flightRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * PUT /flight : Add flight, id unnecessary
     *
     * @param flight (optional)
     * @return Add successful (status code 200)
     * or Add failed (status code 400)
     * @see FlightApi#addFlight
     */
    @Override
    public ResponseEntity<Flight> addFlight(Flight flight) {
        if ( flight.getId() != null && flightRepo.existsById(UUID.fromString(flight.getId()))) return ResponseEntity.badRequest().body(null);
        try {
            FlightEnt newFlight = flightRepo.save(convertToEntity(flight));
            if (newFlight.getId() == null) return ResponseEntity.badRequest().body(null);
            return ResponseEntity.ok(convertToDTO(newFlight));
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * DELETE /flight/{flightId} : Delete flight at id
     *
     * @param flightId (required)
     * @return Delete successful (status code 200)
     * or Delete failed (status code 400)
     * @see FlightApi#deleteFlight
     */
    @Override
    public ResponseEntity<Void> deleteFlight(String flightId) {
        try {
            flightRepo.deleteById(UUID.fromString(flightId));
            return ResponseEntity.ok(null);
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /flight : Get all flights
     *
     * @return Read successful (status code 200)
     * or How did you mess this up (status code 400)
     * @see FlightApi#getAllFlights
     */
    @Override
    public ResponseEntity<List<Flight>> getAllFlights() {
        try {
            List<Flight> flights = new ArrayList<>();
            flightRepo.findAll().forEach(ent -> flights.add(convertToDTO(ent)));
            return new ResponseEntity<>(flights, HttpStatus.OK);
        } catch (Exception ignored) {
        }

        return ResponseEntity.badRequest().body(new ArrayList<>());
    }

    /**
     * GET /flight/{flightId} : Get flight at id
     *
     * @param flightId (required)
     * @return Read successful (status code 200)
     * or How did you mess this up (status code 400)
     * @see FlightApi#getFlight
     */
    public ResponseEntity<Flight> getFlight(String flightId) {
        try {
            Optional<FlightEnt> opEnt = flightRepo.findById(UUID.fromString(flightId));
            if (opEnt.isPresent())
                return ResponseEntity.ok(
                        convertToDTO(opEnt.get())
                );
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * POST /flight/{flightId} : Update flight at id
     *
     * @param flightId (required)
     * @param flight   (optional)
     * @return Update successful (status code 200)
     * or Update failed (status code 400)
     * @see FlightApi#updateFlight
     */
    @Override
    public ResponseEntity<Void> updateFlight(String flightId, Flight flight) {
        if (flight != null) {
            try {
                Optional<FlightEnt> opEnt = flightRepo.findById(UUID.fromString(flightId));
                if (opEnt.isPresent()) {
                    FlightEnt entity = opEnt.get();
                    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
                    modelMapper.map(convertToEntity(flight), entity);
                    flightRepo.save(entity);
                }
            } catch (Exception ignored) {
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    private Flight convertToDTO(FlightEnt flightEnt) {
        Flight flight = modelMapper.map(flightEnt, Flight.class);
        flight.setRoute(modelMapper.map(flight.getRoute(), Route.class));
        flight.setDepartureTime(flightEnt.getDepartureTime().toOffsetDateTime());
        flight.setAirplane(modelMapper.map(flightEnt.getAirplane(), Airplane.class));
        return flight;
    }

    private FlightEnt convertToEntity(Flight flight) {
        FlightEnt flightEnt = modelMapper.map(flight, FlightEnt.class);
        if (flight.getAirplane() != null)
            flightEnt.setAirplane(new AirplaneEnt().setId(UUID.fromString(flight.getAirplane().getId())));
        if (flight.getRoute() != null)
            flightEnt.setRoute(new RouteEnt().setId(UUID.fromString(flight.getRoute().getId())));
        if (flight.getDepartureTime() != null)
            flightEnt.setDepartureTime(flight.getDepartureTime().atZoneSameInstant(ZoneId.of("UTC")));
        return flightEnt;
    }
}
