package pl.terminal.server.application.traveler.profile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.TravelerProfileRepository;
import pl.terminal.server.domain.traveler.profile.UpdateProfileRequest;

@Service
public class TravelerProfileService {

	private final TravelerProfileRepository repository;

	@Autowired
	public TravelerProfileService(TravelerProfileRepository repository) {
		this.repository = repository;
	}

	public TravelerProfile getProfile(TravelerId travelerId) {
		return repository.getProfileFor(travelerId);
	}

	public void updateProfile(UpdateProfileRequest request) {
		TravelerProfile profile = repository.getProfileFor(request.getTravelerId());
		profile.updateProfile(request);
		repository.updateProfile(profile);
	}

	public List<TravelerProfile> getAllProfiles() {
		return repository.getAllProfiles();
	}
}
