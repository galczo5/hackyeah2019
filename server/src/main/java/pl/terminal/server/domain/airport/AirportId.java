package pl.terminal.server.domain.airport;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportId {
    private Long airportId;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AirportId airportId1 = (AirportId) o;
		return Objects.equals(airportId, airportId1.airportId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airportId);
	}
}
