package pl.terminal.server.rest.traveler.profile;

import java.util.Set;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.languages.Language;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;


@SuppressWarnings("WeakerAccess")
public class TravelerProfileDTO {

	public String travelerId;

	public String nickname;

	public Nationality nationality;

	public Set<Language> languages;

	public TravelerProfileDTO(TravelerProfile profile) {
		this.travelerId = profile.getTravelerId().getId();
		this.nickname = profile.getNickname().getInternal();
		this.nationality = profile.getNationality();
		this.languages = profile.getLanguages().getAsSet();
	}
}
