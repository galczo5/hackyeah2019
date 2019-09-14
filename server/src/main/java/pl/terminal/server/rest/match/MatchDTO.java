package pl.terminal.server.rest.match;

import java.util.Set;
import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.rest.traveler.profile.TravelerProfileDTO;

@SuppressWarnings("WeakerAccess")
public class MatchDTO {

	public TravelerProfileDTO profile;

	public Set<Need> needs;

	public TimeAvailability timeAvailability;

	public MatchDTO(Match match) {
		this.profile = new TravelerProfileDTO(match.getProfile());
		this.needs = match.getNeeds();
		this.timeAvailability = match.getTimeAvailability();
	}
}
