package pl.terminal.server.infrastructure.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.coordinates.Coordinates;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AirportsService {

    @Autowired
    private AirportsRepository airportsRepository;

    @Autowired
    private JpaAirportConverter jpaAirportConverter;

    public Set<Airport> getAllAirports() {
        return airportsRepository.getAirports()
                .stream()
                .map(jpaAirport -> jpaAirportConverter.convert(jpaAirport))
                .collect(Collectors.toSet());
    }

    public Airport findAirportByCoordinates(Coordinates coordinates) {
        return airportsRepository.getAirports()
                .stream()
                .filter(jpaAirport -> checkIfInRadius(coordinates, Coordinates.fromLonLat(
                        jpaAirport.getLatitude(),
                        jpaAirport.getLongitude()), 1))
                .map(jpaAirport -> Pair.of(jpaAirport, getDistanceBetweenPoints(coordinates, Coordinates.fromLonLat(
                        jpaAirport.getLatitude(),
                        jpaAirport.getLongitude()))))
                .sorted(Comparator.comparing(Pair::getSecond))
                .map(airportDistancePair -> jpaAirportConverter.convert(airportDistancePair.getFirst()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private double getDistanceBetweenPoints(Coordinates coordinates, Coordinates airportCoordinates) {
        double x1 = airportCoordinates.getLatitude();
        double x2 = coordinates.getLatitude();

        double y1 = airportCoordinates.getLongitude();
        double y2 = coordinates.getLongitude();
        return Math.hypot(x1-x2, y1-y2);
    }

    private boolean checkIfInRadius(Coordinates userCoordinates, Coordinates airportCoordinates, double radius) {
        double dx = Math.abs(userCoordinates.getLatitude()-airportCoordinates.getLatitude());
        double dy = Math.abs(userCoordinates.getLongitude()-airportCoordinates.getLongitude());

        return (dx + dy) <= radius;
    }

}
