package pl.terminal.server.domain.need;

import java.util.Objects;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.traveler.TravelerId;

@Getter
@Builder
public class NeedRequest {

	private final TravelerId travelerId;

	private final Set<Need> needs;

	private final AirportId airportId;

	private final TimeAvailability timeAvailability;

	public NeedRequest(TravelerId travelerId, Set<Need> needs, AirportId airportId, TimeAvailability timeAvailability) {
		this.travelerId = travelerId;
		this.needs = needs;
		this.airportId = airportId;
		this.timeAvailability = timeAvailability;
	}

	public AirportId getAirportId() {
		return airportId;
	}

	public TimeAvailability getTimeAvailability() {
		return timeAvailability;
	}

	public TravelerId getTravelerId() {
		return travelerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NeedRequest that = (NeedRequest) o;
		return Objects.equals(travelerId, that.travelerId) &&
				needs == that.needs &&
				Objects.equals(airportId, that.airportId) &&
				Objects.equals(timeAvailability, that.timeAvailability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(travelerId, needs, airportId, timeAvailability);
	}
}
