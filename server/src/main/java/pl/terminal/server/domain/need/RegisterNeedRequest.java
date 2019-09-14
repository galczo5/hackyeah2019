package pl.terminal.server.domain.need;

import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.traveler.TravelerId;

public class RegisterNeedRequest {

	private final TravelerId travelerId;

	private final Need need;

	private final AirportId airportId;

	private final TimeAvailability timeAvailability;

	public RegisterNeedRequest(TravelerId travelerId, Need need, AirportId airportId, TimeAvailability timeAvailability) {
		this.travelerId = travelerId;
		this.need = need;
		this.airportId = airportId;
		this.timeAvailability = timeAvailability;
	}
}
