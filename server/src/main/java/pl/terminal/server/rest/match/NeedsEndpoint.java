package pl.terminal.server.rest.match;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.terminal.server.application.match.MatchingService;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.MatchAcceptResult;
import pl.terminal.server.domain.need.NeedRequestId;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("needs")
public class NeedsEndpoint {

	private final MatchingService matchingService;

	private final TravelerProfileService profileService;

	@Autowired
	public NeedsEndpoint(MatchingService matchingService, TravelerProfileService profileService) {
		this.matchingService = matchingService;
		this.profileService = profileService;
	}

	@GetMapping(value = "/match/{requestId}", produces = "application/json")
	public List<MatchDTO> getMatches(@PathVariable Long requestId) {
		final List<Match> matches = matchingService.matchNeed(new NeedRequestId(requestId));
		return matches.stream()
				.map(match -> new MatchDTO(match, profileService.getProfile(match.getTravalerId())))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/register")
	public NeedRequestId registerNeed(@RequestBody RegisterNeedRequestDTO requestDTO) {
		return matchingService.registerNeed(requestDTO.toDomain());
	}

	@PostMapping("/match/{requestId}/{matchRequestId}/accept")
	public ResponseEntity<MatchAcceptResult> acceptMatch(@PathVariable Long requestId, @PathVariable Long matchRequestId) {
		try {
			MatchAcceptResult matchAcceptResult = matchingService.acceptMatch(
					new NeedRequestId(requestId),
					new NeedRequestId(matchRequestId));
			return ResponseEntity.ok(matchAcceptResult);
		} catch(IllegalArgumentException e) {
			log.error("Exception in acceptMatch = {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().build();
		}
	}
}
