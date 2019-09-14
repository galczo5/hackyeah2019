package pl.terminal.server.rest.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirportSearchQuery {
    private double latitude;
    private double longitude;
}
