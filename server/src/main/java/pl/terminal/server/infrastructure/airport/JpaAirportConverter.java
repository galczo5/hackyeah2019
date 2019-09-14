package pl.terminal.server.infrastructure.airport;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.terminal.server.domain.airport.Airport;

@Component
public class JpaAirportConverter implements Converter<JpaAirport, Airport> {
    @Override
    public Airport convert(JpaAirport jpaAirport) {
        return Airport.builder()
                .id(jpaAirport.getId())
                .name(jpaAirport.getName())
                .code(jpaAirport.getCode())
                .build();
    }
}
