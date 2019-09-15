package pl.terminal.server.rest.traveler.achievements;

import pl.terminal.server.domain.airport.Airport;

@SuppressWarnings("WeakerAccess")
public class AirportAchievementDTO {

	public Airport airport;

	public int score;

	public AirportAchievementDTO(Airport airport, int score) {
		this.airport = airport;
		this.score = score;
	}
}
