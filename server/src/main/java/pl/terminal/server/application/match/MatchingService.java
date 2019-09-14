package pl.terminal.server.application.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.*;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.domain.traveler.profile.languages.Languages;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MatchingService {

	private final NeedService needService;

	private final TravelerProfileService profileService;

	@Autowired
	public MatchingService(NeedService needService, TravelerProfileService profileService) {
		this.needService = needService;
		this.profileService = profileService;
	}

	public NeedRequestId registerNeed(RegisterNeedRequest request) {
		return needService.registerNeed(request);
	}

	public List<Match> matchNeed(NeedRequestId requestId) {
		final NeedRequest need = needService.findNeedRequest(requestId);
		final List<NeedRequest> requests = needService.findActiveNeedRequestsByAirport(need.getAirportId());
		final Map<NeedRequest, Integer> factors = calculateMatchFactors(need, requests);
		return getBestMatches(factors);
	}

	private Map<NeedRequest, Integer> calculateMatchFactors(NeedRequest need, List<NeedRequest> requests) {
		final TravelerProfile profile = profileService.getProfile(need.getTravelerId());
		return requests.stream()
				.filter(request -> !request.getTravelerId().equals(profile.getTravelerId()))
				.collect(Collectors.toMap(
						Function.identity(),
						request -> calculateMatchFactor(need, profile, request)
				));
	}

	private Integer calculateMatchFactor(NeedRequest needToMatch, TravelerProfile profileToMatch, NeedRequest candidate) {
		final Integer timeAvailabilityFactor = calculateTimeAvailabilityFactor(needToMatch.getTimeAvailability(), candidate.getTimeAvailability());
		final Integer needsFactor = calculateNeedsFactor(needToMatch.getNeeds(), candidate.getNeeds());
		final Integer profileFactor = calculateProfileFactor(profileToMatch, profileService.getProfile(candidate.getTravelerId()));
		return timeAvailabilityFactor * needsFactor * profileFactor;

	}

	private Integer calculateProfileFactor(TravelerProfile profile1, TravelerProfile profile2) {
		final Integer languageFactor = calculateLanguageFactor(profile1.getLanguages(), profile2.getLanguages());
		final Integer nationalityFactor = calculateNationalityFactor(profile1.getNationality(), profile2.getNationality());
		if (languageFactor == 0) {
			return languageFactor;
		}
		return languageFactor + nationalityFactor;
	}

	private int calculateNationalityFactor(Nationality nationality1, Nationality nationality2) {
		return nationality1 == nationality2 ? 0 : 1;
	}

	private Integer calculateLanguageFactor(Languages languages1, Languages languages2) {
		return languages1.commonCount(languages2);
	}

	private Integer calculateNeedsFactor(Set<Need> needs1, Set<Need> needs2) {
		return Long.valueOf(
				needs1.stream()
						.filter(needs2::contains)
						.count()
		).intValue();
	}

	private Integer calculateTimeAvailabilityFactor(TimeAvailability timeAvailability1, TimeAvailability timeAvailability2) {
		final Integer commonMinutes = timeAvailability1.commonMinutes(timeAvailability2);
		if (commonMinutes < 30) {
			return 0;
		}
		return Double.valueOf(Math.floor(Double.valueOf(commonMinutes) / 30.0)).intValue();
	}

	private List<Match> getBestMatches(Map<NeedRequest, Integer> factors) {
		List<Match> matches = new ArrayList<>();
		factors.entrySet().stream()
				.filter(e -> e.getValue() > 0)
				.sorted(Map.Entry.comparingByValue())
				.forEachOrdered(e -> {
					final Match match = toMatch(e.getKey());
					matches.add(match);
				});
		return matches;
	}

	private Match toMatch(NeedRequest request) {
		return new Match(
				request.getTravelerId(),
				request.getNeeds(),
				request.getTimeAvailability(),
				request.getNeedRequestId()
		);
	}

	public MatchAcceptResult acceptMatch(NeedRequestId needRequestId, NeedRequestId matchAcceptId) {
		return needService.createMatchAccept(needRequestId, matchAcceptId);
	}
}
