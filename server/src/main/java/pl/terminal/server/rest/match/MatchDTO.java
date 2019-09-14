package pl.terminal.server.rest.match;

import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.rest.traveler.profile.TravelerProfileDTO;

import java.util.Set;

@SuppressWarnings("WeakerAccess")
public class MatchDTO {

	public TravelerProfileDTO profile;

	public Set<Need> needs;

	public TimeAvailability timeAvailability;

	public NeedRequestId needRequestId;

	public MatchDTO(Match match, TravelerProfile profile) {
		this.profile = new TravelerProfileDTO(profile);
		this.needs = match.getNeeds();
		this.timeAvailability = match.getTimeAvailability();
		this.needRequestId = match.getNeedRequestId();
	}
}
