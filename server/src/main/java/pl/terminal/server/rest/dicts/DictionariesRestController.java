package pl.terminal.server.rest.dicts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.infrastructure.airport.AirportsService;

import java.util.Set;

@RestController
@RequestMapping("/api/dicts")
public class DictionariesRestController {

    @Autowired
    private AirportsService airportsService;

    @GetMapping("airports")
    public ResponseEntity<Set<Airport>> getAirports() {
        return ResponseEntity.ok(airportsService.getAllAirports());
    }
}
