package pl.terminal.server.domain.coordinates;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
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
