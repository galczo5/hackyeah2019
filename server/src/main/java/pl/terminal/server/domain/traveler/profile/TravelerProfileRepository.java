package pl.terminal.server.domain.traveler.profile;

import java.util.List;
import pl.terminal.server.domain.traveler.TravelerId;

public interface TravelerProfileRepository {

	TravelerProfile getProfileFor(TravelerId travelerId);

	void updateProfile(TravelerProfile profile);

	List<TravelerProfile> getAllProfiles();

}
