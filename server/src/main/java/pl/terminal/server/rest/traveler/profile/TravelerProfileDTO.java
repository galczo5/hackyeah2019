package pl.terminal.server.rest.traveler.profile;

import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.languages.Language;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

import java.util.Set;
import java.util.stream.Collectors;


@SuppressWarnings("WeakerAccess")
public class TravelerProfileDTO {

	public Long travelerId;

	public String nickname;

	public Nationality nationality;

	public Set<String> languages;

	public String avatar;

	public TravelerProfileDTO(TravelerProfile profile) {
		this.travelerId = profile.getTravelerId().getId();
		this.nickname = profile.getNickname().getInternal();
		this.nationality = profile.getNationality();
		this.languages = profile.getLanguages().getAsSet().stream().map(Language::getHumanName).collect(Collectors.toSet());
		this.avatar = profile.getAvatar().getAvatar();
	}
}
