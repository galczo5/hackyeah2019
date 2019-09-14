package pl.terminal.server.rest.airport;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.infrastructure.airport.AirportsService;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/airport")
public class AirportRestController {

    @Autowired
    private AirportsService airportsService;

    @GetMapping
    public ResponseEntity<Set<Airport>> getAirports(AirportSearchQuery airportSearchQuery) {
        try {
            return ResponseEntity.ok(airportsService.getAllAirportsByQuery(airportSearchQuery));
        } catch(Exception e) {
            log.error("Exception = {}", ExceptionUtils.getStackTrace(e));
            return ResponseEntity.badRequest().build();
        }
    }
}
