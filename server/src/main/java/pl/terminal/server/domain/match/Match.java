package pl.terminal.server.domain.match;

import java.util.Set;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

public class Match {

	private final TravelerId travelerId;

	private final Set<Need> needs;

	private final TimeAvailability timeAvailability;

	public Match(TravelerId travelerId, Set<Need> needs, TimeAvailability timeAvailability) {
		this.travelerId = travelerId;
		this.needs = needs;
		this.timeAvailability = timeAvailability;
	}

	public TravelerId getTravalerId() {
		return travelerId;
	}

	public Set<Need> getNeeds() {
		return needs;
	}

	public TimeAvailability getTimeAvailability() {
		return timeAvailability;
	}
}
