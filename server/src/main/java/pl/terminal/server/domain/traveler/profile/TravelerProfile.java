package pl.terminal.server.domain.traveler.profile;

import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

public class TravelerProfile {

	private final TravelerId travelerId;

	private Nickname nickname;

	private Nationality nationality;

	private Languages languages;

	private Avatar avatar;

	public TravelerProfile(TravelerId travelerId,
			Nickname nickname,
			Nationality nationality,
			Languages languages,
		    Avatar avatar) {
		this.travelerId = travelerId;
		this.nickname = nickname;
		this.nationality = nationality;
		this.languages = languages;
		this.avatar = avatar;
	}

	private TravelerProfile(TravelerId travelerId) {
		this.travelerId = travelerId;
		this.nickname = Nickname.empty();
		this.nationality = null;
		this.languages = Languages.empty(travelerId);
		this.avatar = Avatar.empty();
	}

	public static TravelerProfile empty(TravelerId travelerId) {
		return new TravelerProfile(travelerId);
	}

	public TravelerId getTravelerId() {
		return travelerId;
	}

	public Nickname getNickname() {
		return nickname;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public Languages getLanguages() {
		return languages;
	}

	public void updateProfile(UpdateProfileRequest request) {
		this.nickname = request.getNickname();
		this.nationality = request.getNationality();
		this.languages = request.getLanguages();
		this.avatar = request.getAvatar();
	}
}
