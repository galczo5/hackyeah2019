package pl.terminal.server.domain.traveler.profile;

import java.util.Set;
import lombok.Getter;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.languages.Language;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@Getter
public class UpdateProfileRequest {

	private final TravelerId travelerId;

	private final Nickname nickname;

	private final Nationality nationality;

	private final Languages languages;

	public UpdateProfileRequest(TravelerId travelerId, Nickname nickname, Nationality nationality, Languages languages) {

		this.travelerId = travelerId;
		this.nickname = nickname;
		this.nationality = nationality;
		this.languages = languages;
	}
}
