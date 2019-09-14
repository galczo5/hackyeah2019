package pl.terminal.server.rest.match;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.match.MatchingService;
import pl.terminal.server.domain.match.Match;
import pl.terminal.server.domain.need.NeedRequestId;

@RestController
@RequestMapping("needs")
public class NeedsEndpoint {

	private final MatchingService matchingService;

	public NeedsEndpoint(MatchingService matchingService) {
		this.matchingService = matchingService;
	}

	@GetMapping(value = "/match", produces = "application/json")
	public List<MatchDTO> getMatches(@PathVariable Long requestId) {
		final List<Match> matches = matchingService.matchNeed(new NeedRequestId(requestId));
		return matches.stream()
				.map(MatchDTO::new)
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/register")
	public NeedRequestId registerNeed(@RequestBody RegisterNeedRequestDTO requestDTO) {
		return matchingService.registerNeed(requestDTO.toDomain());
	}
}
