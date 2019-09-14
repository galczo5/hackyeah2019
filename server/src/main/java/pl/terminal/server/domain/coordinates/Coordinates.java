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
}
