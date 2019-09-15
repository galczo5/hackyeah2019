package pl.terminal.server.rest.match;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.match.MatchRemoveResponse;
import pl.terminal.server.application.match.MatchingService;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.MatchAcceptResult;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.infrastructure.need.MatchId;
import pl.terminal.server.infrastructure.security.SecurityService;

@Slf4j
@RestController
@RequestMapping("/api/needs")
public class NeedsEndpoint {

	private final SecurityService securityService;

	private final MatchingService matchingService;

	private final TravelerProfileService profileService;

	@Autowired
	public NeedsEndpoint(SecurityService securityService,
			MatchingService matchingService,
			TravelerProfileService profileService) {
		this.securityService = securityService;
		this.matchingService = matchingService;
		this.profileService = profileService;
	}

	@GetMapping(value = "match/{requestId}", produces = "application/json")
	public List<MatchDTO> getMatches(@PathVariable Long requestId) {
		final List<Match> matches = matchingService.matchNeed(new NeedRequestId(requestId));
		return matches.stream()
				.map(match -> new MatchDTO(match, profileService.getProfile(match.getTravelerId())))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "register")
	public NeedRequestId registerNeed(@RequestBody RegisterNeedRequestDTO requestDTO) {
		return matchingService.registerNeed(requestDTO.toDomain(new TravelerId(securityService.findLoggedInUserId())));
	}

	@PostMapping("match")
	public ResponseEntity<MatchAcceptResult> acceptMatch(@RequestBody MatchRequest acceptMatchRequest) {
		try {
			MatchAcceptResult matchAcceptResult = matchingService.acceptMatch(
					acceptMatchRequest.getRequestId(),
					acceptMatchRequest.getMatchRequestId());
			return ResponseEntity.ok(matchAcceptResult);
		} catch(IllegalArgumentException e) {
			log.error("Exception in acceptMatch = {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("match")
	public ResponseEntity<MatchRemoveResponse> deleteMatched(@RequestBody MatchId matchId) {
		try {
			MatchRemoveResponse matchRemoveResult = matchingService.removeMatch(matchId);
			return ResponseEntity.ok(matchRemoveResult);
		} catch(IllegalArgumentException e) {
			log.error("Exception in deleteMAtch = {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().build();
		}
	}
}
