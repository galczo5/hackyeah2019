package pl.terminal.server.domain.match;

import java.util.Objects;
import java.util.Set;
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

	public TravelerId getTravelerId() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Match match = (Match) o;
		return Objects.equals(travelerId, match.travelerId) &&
				Objects.equals(needs, match.needs) &&
				Objects.equals(timeAvailability, match.timeAvailability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(travelerId, needs, timeAvailability);
	}
}
