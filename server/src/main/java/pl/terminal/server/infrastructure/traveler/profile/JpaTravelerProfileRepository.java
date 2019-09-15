package pl.terminal.server.infrastructure.traveler.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.Avatar;
import pl.terminal.server.domain.traveler.profile.Nickname;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.TravelerProfileRepository;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.infrastructure.traveler.avatar.JpaAvatar;
import pl.terminal.server.infrastructure.traveler.avatar.JpaAvatarCrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JpaTravelerProfileRepository implements TravelerProfileRepository {

	private final JpaTravelerProfileCrudRepository jpaRepository;

	private final JpaAvatarCrudRepository jpaAvatarCrudRepository;

	@Autowired
	public JpaTravelerProfileRepository(JpaTravelerProfileCrudRepository jpaRepository, JpaAvatarCrudRepository jpaAvatarCrudRepository) {
		this.jpaRepository = jpaRepository;
		this.jpaAvatarCrudRepository = jpaAvatarCrudRepository;
	}

	@Override
	public TravelerProfile getProfileFor(TravelerId travelerId) {
		final Optional<JpaTravelerProfile> profile = jpaRepository.findById(travelerId.getId());
		return profile
				.map(this::toTravelerProfile)
				.orElse(TravelerProfile.empty(travelerId));
	}

	@Override
	public List<TravelerProfile> getAllProfiles() {
		return StreamSupport.stream(jpaRepository.findAll().spliterator(), false).map(this::toTravelerProfile).collect(Collectors.toList());
	}

	private TravelerProfile toTravelerProfile(JpaTravelerProfile jpaTravelerProfile) {
		return new TravelerProfile(
				new TravelerId(jpaTravelerProfile.getTravelerId()),
				new Nickname(jpaTravelerProfile.getNickname()),
				jpaTravelerProfile.getNationality(),
				new Languages(jpaTravelerProfile.getLanguages()),
				mapJpaAvatar(jpaAvatarCrudRepository.findByNationality(jpaTravelerProfile.getNationality()))
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

	private Avatar mapJpaAvatar(JpaAvatar avatar) {
		return new Avatar(avatar.getAvatar());
	}
}
