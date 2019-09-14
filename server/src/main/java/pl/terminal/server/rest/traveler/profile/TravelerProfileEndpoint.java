package pl.terminal.server.rest.traveler.profile;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;

@RestController
@RequestMapping("profiles")
public class TravelerProfileEndpoint {

	private final TravelerProfileService profileService;

	@Autowired
	public TravelerProfileEndpoint(TravelerProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping(value = "/{travelerId}", produces = "application/json")
	public TravelerProfileDTO getProfile(@PathVariable Long travelerId) {
		final TravelerProfile profile = profileService.getProfile(new TravelerId(travelerId));
		return new TravelerProfileDTO(profile);
	}

	@PostMapping(value = "/{travelerId}")
	public void updateProfile(@PathVariable Long travelerId, @RequestBody UpdateProfileRequestDTO requestDTO) {
		profileService.updateProfile(requestDTO.toDomain(new TravelerId(travelerId)));
	}

	@GetMapping(produces = "application/json")
	public List<TravelerProfileDTO> getProfiles() {
		final List<TravelerProfile> profiles = profileService.getAllProfiles();
		return profiles.stream().map(TravelerProfileDTO::new).collect(Collectors.toList());
	}



}
