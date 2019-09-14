package pl.terminal.server.domain.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.terminal.server.domain.coordinates.Coordinates;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Airport {
    private Long id;
    private String name;
    private String code;
    private Coordinates coordinates;
}
