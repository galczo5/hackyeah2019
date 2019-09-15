package pl.terminal.server.rest.traveler.achievements;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.traveler.achievements.AchievementService;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.nationality.CountryAvatarService;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;
import pl.terminal.server.infrastructure.security.SecurityService;

@RestController
@RequestMapping("api/achievements")
public class AchievementEndpoint {

	private final AchievementService achievementService;

	private final CountryAvatarService countryAvatarService;

	private final SecurityService securityService;

	@Autowired
	public AchievementEndpoint(AchievementService achievementService,
			CountryAvatarService countryAvatarService,
			SecurityService securityService) {
		this.achievementService = achievementService;
		this.countryAvatarService = countryAvatarService;
		this.securityService = securityService;
	}

	@GetMapping(produces = "application/json")
	AchievementsDTO getAchievements() {
		final TravelerId travelerId = new TravelerId(securityService.findLoggedInUserId());
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
