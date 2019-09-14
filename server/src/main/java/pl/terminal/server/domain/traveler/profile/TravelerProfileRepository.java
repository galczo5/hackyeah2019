package pl.terminal.server.domain.traveler.profile;

import pl.terminal.server.domain.traveler.TravelerId;

public interface TravelerProfileRepository {

	TravelerProfile getProfileFor(TravelerId travelerId);

	void updateProfile(TravelerProfile profile);

}
