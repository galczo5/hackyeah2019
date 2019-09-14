package pl.terminal.server.domain.match;

import java.util.Set;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;

public class Match {

	private final TravelerProfile profile;

	private final Set<Need> needs;

	private final TimeAvailability timeAvailability;

	public Match(TravelerProfile profile, Set<Need> needs, TimeAvailability timeAvailability) {
		this.profile = profile;
		this.needs = needs;
		this.timeAvailability = timeAvailability;
	}

	public TravelerProfile getProfile() {
		return profile;
	}

	public Set<Need> getNeeds() {
		return needs;
	}

	public TimeAvailability getTimeAvailability() {
		return timeAvailability;
	}
}
