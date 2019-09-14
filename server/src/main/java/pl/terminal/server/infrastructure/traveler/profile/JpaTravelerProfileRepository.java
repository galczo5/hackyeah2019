package pl.terminal.server.infrastructure.traveler.profile;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.Nickname;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.TravelerProfileRepository;
import pl.terminal.server.domain.traveler.profile.languages.Languages;

@Service
public class JpaTravelerProfileRepository implements TravelerProfileRepository {

	private final JpaTravelerProfileCrudRepository jpaRepository;

	@Autowired
	public JpaTravelerProfileRepository(JpaTravelerProfileCrudRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public TravelerProfile getProfileFor(TravelerId travelerId) {
		final Optional<JpaTravelerProfile> profile = jpaRepository.findById(travelerId.getId());
		return profile
				.map(this::toTravelerProfile)
				.orElse(TravelerProfile.empty(travelerId));
	}

	private TravelerProfile toTravelerProfile(JpaTravelerProfile jpaTravelerProfile) {
		return new TravelerProfile(
				new TravelerId(jpaTravelerProfile.getTravelerId()),
				new Nickname(jpaTravelerProfile.getNickname()),
				jpaTravelerProfile.getNationality(),
				new Languages(jpaTravelerProfile.getLanguages())
		);
	}

	@Override
	public void updateProfile(TravelerProfile profile) {
		jpaRepository.save(new JpaTravelerProfile(
				profile.getTravelerId().getId(),
				profile.getNickname().getInternal(),
				profile.getNationality(),
				profile.getLanguages().getAsSet()
		));
	}
}
