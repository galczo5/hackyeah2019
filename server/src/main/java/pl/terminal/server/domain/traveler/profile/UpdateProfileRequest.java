package pl.terminal.server.domain.traveler.profile;

import lombok.Getter;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@Getter
public class UpdateProfileRequest {

	private final TravelerId travelerId;

	private final Nickname nickname;

	private final Nationality nationality;

	private final Languages languages;

	private final Avatar avatar;

	public UpdateProfileRequest(TravelerId travelerId, Nickname nickname, Nationality nationality, Languages languages, Avatar avatar) {
		this.travelerId = travelerId;
		this.nickname = nickname;
		this.nationality = nationality;
		this.languages = languages;
		this.avatar = avatar;
	}
}
