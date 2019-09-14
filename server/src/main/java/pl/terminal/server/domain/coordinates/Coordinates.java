package pl.terminal.server.domain.coordinates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coordinates {
    private double latitude;
    private double longitude;

    public static Coordinates fromLonLat(double latitude, double longitude) {
        return Coordinates.builder()
                .longitude(longitude)
                .latitude(latitude)
                .build();
    }
}
