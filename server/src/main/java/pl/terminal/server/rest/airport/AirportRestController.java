package pl.terminal.server.rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.coordinates.Coordinates;
import pl.terminal.server.infrastructure.airport.AirportsService;

import java.util.Set;

@RestController
@RequestMapping("/api/airport")
public class AirportRestController {

    @Autowired
    private AirportsService airportsService;

    @GetMapping
    public ResponseEntity<Set<Airport>> getAirports() {
        return ResponseEntity.ok(airportsService.getAllAirports());
    }

    @GetMapping("coordinates")
    public ResponseEntity<Airport> getAirportByCoordinates(Coordinates coordinates) {
        try {
            return ResponseEntity.ok(airportsService.findAirportByCoordinates(coordinates));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
