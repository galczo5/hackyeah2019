package pl.terminal.server.domain.airport;

import java.util.Objects;
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
    private MeetingPoint meetingPoint;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Airport airport = (Airport) o;
		return Objects.equals(id, airport.id) &&
				Objects.equals(name, airport.name) &&
				Objects.equals(code, airport.code) &&
				Objects.equals(coordinates, airport.coordinates) &&
				Objects.equals(meetingPoint, airport.meetingPoint);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, code, coordinates, meetingPoint);
	}
}
