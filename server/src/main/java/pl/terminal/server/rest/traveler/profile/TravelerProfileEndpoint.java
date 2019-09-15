package pl.terminal.server.rest.traveler.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.infrastructure.security.SecurityService;

@RestController
@RequestMapping("profiles")
public class TravelerProfileEndpoint {

	private final SecurityService securityService;

	private final TravelerProfileService profileService;

	@Autowired
	public TravelerProfileEndpoint(SecurityService securityService, TravelerProfileService profileService) {
		this.securityService = securityService;
		this.profileService = profileService;
	}

	@PostMapping(value = "/{travelerId}")
	public void updateProfile(@PathVariable Long travelerId, @RequestBody UpdateProfileRequestDTO requestDTO) {
		profileService.updateProfile(requestDTO.toDomain(new TravelerId(travelerId)));
	}

	@GetMapping(produces = "application/json")
	public TravelerProfileDTO getProfile() {
		final TravelerId loggedInTraveler = new TravelerId(securityService.findLoggedInUserId());
		return new TravelerProfileDTO(profileService.getProfile(loggedInTraveler));
	}



}
