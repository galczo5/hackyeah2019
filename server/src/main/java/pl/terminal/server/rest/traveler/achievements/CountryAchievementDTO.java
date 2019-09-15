package pl.terminal.server.rest.traveler.achievements;

import pl.terminal.server.domain.traveler.profile.Avatar;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@SuppressWarnings("WeakerAccess")
public class CountryAchievementDTO {

	public int score;

	public Avatar avatar;

	public Nationality nationality;

	public CountryAchievementDTO(int score, Avatar avatar, Nationality nationality) {
		this.score = score;
		this.avatar = avatar;
		this.nationality = nationality;
	}
}
