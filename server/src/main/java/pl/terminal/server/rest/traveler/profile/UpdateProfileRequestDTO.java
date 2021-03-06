package pl.terminal.server.rest.traveler.profile;

import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.Avatar;
import pl.terminal.server.domain.traveler.profile.Nickname;
import pl.terminal.server.domain.traveler.profile.UpdateProfileRequest;
import pl.terminal.server.domain.traveler.profile.languages.Language;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

import java.util.Set;

@SuppressWarnings("WeakerAccess")
public class UpdateProfileRequestDTO {

	public String nickname;

	public Nationality nationality;

	public Set<Language> languages;

	public String avatar;

	public UpdateProfileRequest toDomain(TravelerId travelerId) {
		return new UpdateProfileRequest(
				travelerId,
				new Nickname(nickname),
				nationality,
				new Languages(languages),
				new Avatar(avatar)
		);
	}
}
