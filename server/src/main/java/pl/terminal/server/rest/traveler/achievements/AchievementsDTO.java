package pl.terminal.server.rest.traveler.achievements;

import java.util.List;

@SuppressWarnings("ALL")
public class AchievementsDTO {

	public List<AirportAchievementDTO> airports;

	public List<CountryAchievementDTO> countries;

	public AchievementsDTO(List<AirportAchievementDTO> airports, List<CountryAchievementDTO> countries) {
		this.airports = airports;
		this.countries = countries;
	}
}
