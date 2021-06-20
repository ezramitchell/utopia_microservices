package com.ss.adminservice;

import com.ss.adminservice.entity.*;
import com.ss.adminservice.repo.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ApplicationRunner getRunner(
            AirplaneRepo airplaneRepo,
            AirplaneTypeRepo airplaneTypeRepo,
            AirportRepo airportRepo,
            FlightRepo flightRepo,
            RouteRepo routeRepo
    ){
        return args -> {
            //initialize data
            //add two airports
            AirportEnt airportEnt = new AirportEnt("ATL", "Atlanta");
            if(!airportRepo.existsById(airportEnt.getIataId())) {
                airportRepo.save(airportEnt);
            }
            airportEnt = new AirportEnt("DEN", "Denver");
            if(!airportRepo.existsById(airportEnt.getIataId())) {
                airportRepo.save(airportEnt);
            }
            //add route
            if(routeRepo.findAll().spliterator().getExactSizeIfKnown() == 0) {
                routeRepo.save(new RouteEnt()
                        .setDestinationAirport(new AirportEnt().setIataId("ATL"))
                        .setOriginAirport(new AirportEnt().setIataId("DEN")));
            }
            //add airplane type if none
            if(airplaneTypeRepo.findAll().spliterator().getExactSizeIfKnown() == 0)
                airplaneTypeRepo.save(new AirplaneTypeEnt().setMaxCapacity(47));
            //add airplane if none
            if(airplaneRepo.findAll().spliterator().getExactSizeIfKnown() == 0)
                airplaneRepo.save(new AirplaneEnt().setAirplaneType(
                        airplaneTypeRepo.findAll().iterator().next()));
            //add flight if none
            if (flightRepo.findAll().spliterator().getExactSizeIfKnown() == 0) {
                flightRepo.save(new FlightEnt()
                        .setAirplane(airplaneRepo.findAll().iterator().next())
                        .setRoute(routeRepo.findAll().iterator().next())
                        .setDepartureTime(LocalDateTime.now().atZone(ZoneId.of("UTC")))
                        .setReservedSeats(40)
                        .setSeatPrice(40.53f));
            }
        };
    }
}
