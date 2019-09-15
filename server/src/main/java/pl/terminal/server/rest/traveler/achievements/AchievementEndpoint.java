package pl.terminal.server.rest.traveler.achievements;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.traveler.achievements.AchievementService;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.nationality.CountryAvatarService;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@RestController
@RequestMapping("api/achievements")
public class AchievementEndpoint {

	private final AchievementService achievementService;

	private final CountryAvatarService countryAvatarService;

	@Autowired
	public AchievementEndpoint(AchievementService achievementService, CountryAvatarService countryAvatarService) {
		this.achievementService = achievementService;
		this.countryAvatarService = countryAvatarService;
	}

	@GetMapping(value = "/{travelerIdRaw}", produces = "application/json")
	AchievementsDTO getAchievements(@PathVariable Long travelerIdRaw) {
		final TravelerId travelerId = new TravelerId(travelerIdRaw);
		final Map<Airport, Integer> airportAchievements = achievementService.getAirportAchievements(travelerId);
		final Map<Nationality, Integer> countryAchievements = achievementService.getCountryAchievements(travelerId);
		return new AchievementsDTO(
				airportAchievements.entrySet().stream().map(e -> new AirportAchievementDTO(e.getKey(), e.getValue())).collect(Collectors.toList()),
				countryAchievements.entrySet().stream()
						.map(e -> new CountryAchievementDTO(e.getValue(), countryAvatarService.getAvatar(e.getKey()), e.getKey()))
						.collect(Collectors.toList())
		);

	}

}
