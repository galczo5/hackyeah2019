package pl.terminal.server.infrastructure.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.coordinates.Coordinates;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AirportsService {
    @Autowired
    private AirportsRepository airportsRepository;

    public Set<Airport> getAllAirports() {
        return airportsRepository.getAirports()
                .stream()
                .map(jpaAirport -> Airport.builder()
                        .id(jpaAirport.getId())
                        .name(jpaAirport.getName())
                        .code(jpaAirport.getCode())
                        .build())
                .collect(Collectors.toSet());
    }

    public Airport findAirportByCoordinates(Coordinates coordinates) {
//        airportsRepository.getAirports()
//                .stream()
//                .
        return null;
    }

    public boolean checkIfInRadius(Coordinates userCoordinates, Coordinates airportCoordinates, double radius) {
//        double dx = Math.abs(x-center_x)
//        double dy = Math.abs(y-center_y)
        return false;
    }

}
