package pl.terminal.server.domain.need;

import lombok.Getter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.traveler.TravelerId;

import java.util.Set;

@Getter
public class RegisterNeedRequest {

	private final TravelerId travelerId;

	private final Set<Need> needs;

	private final AirportId airportId;

	private final TimeAvailability timeAvailability;

	public RegisterNeedRequest(TravelerId travelerId, Set<Need> needs, AirportId airportId, TimeAvailability timeAvailability) {
		this.travelerId = travelerId;
		this.needs = needs;
		this.airportId = airportId;
		this.timeAvailability = timeAvailability;
	}
}
