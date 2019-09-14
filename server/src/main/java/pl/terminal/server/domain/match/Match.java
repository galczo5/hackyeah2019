package pl.terminal.server.domain.match;

import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

import java.util.Set;

public class Match {

	private final TravelerId travelerId;

	private final Set<Need> needs;

	private final TimeAvailability timeAvailability;

	private final NeedRequestId needRequestId;

	public Match(TravelerId travelerId, Set<Need> needs, TimeAvailability timeAvailability, NeedRequestId needRequestId) {
		this.travelerId = travelerId;
		this.needs = needs;
		this.timeAvailability = timeAvailability;
		this.needRequestId = needRequestId;
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

	public NeedRequestId getNeedRequestId() {
		return needRequestId;
	}
}
