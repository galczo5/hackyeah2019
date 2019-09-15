package pl.terminal.server.application.traveler.achievements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;
import pl.terminal.server.infrastructure.airport.AirportsService;

@Service
public class AchievementService {

	private final NeedService needService;

	private final AirportsService airportsService;

	private final TravelerProfileService profileService;

	@Autowired
	public AchievementService(NeedService needService,
			AirportsService airportsService,
			TravelerProfileService profileService) {
		this.needService = needService;
		this.airportsService = airportsService;
		this.profileService = profileService;
	}

	public Map<Airport, Integer> getAirportAchievements(TravelerId travelerId) {
		final Set<NeedRequest> requests = needService.findNeedRequestsByTraveler(travelerId);
		final Map<Airport, Integer> visitedAirports = new HashMap<>();
		for (NeedRequest request : requests) {
			final Airport airport = airportsService.getAirportById(request.getAirportId());
			visitedAirports.putIfAbsent(airport, 0);
			visitedAirports.put(airport, visitedAirports.get(airport) + 1);
		}
		return visitedAirports;
	}

	public Map<Nationality, Integer> getCountryAchievements(TravelerId travelerId) {
		final HashMap<Nationality, Integer> meetNationalities = new HashMap<>();
		final List<NeedRequest> confirmedNeeds = needService.findConfirmedMatchedNeeds(travelerId);
		for (NeedRequest need : confirmedNeeds) {
			Nationality nationality = profileService.getProfile(need.getTravelerId()).getNationality();
			meetNationalities.putIfAbsent(nationality, 0);
			meetNationalities.put(nationality, meetNationalities.get(nationality) + 1);
		}
		return meetNationalities;
	}
}
