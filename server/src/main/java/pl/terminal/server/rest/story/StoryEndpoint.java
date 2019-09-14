package pl.terminal.server.rest.story;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.story.StoryService;
import pl.terminal.server.application.traveler.profile.TravelerProfileService;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.story.Stories;
import pl.terminal.server.domain.story.StoryId;
import pl.terminal.server.domain.traveler.TravelerId;

@RestController
@RequestMapping("stories")
public class StoryEndpoint {

	private final StoryService storyService;

	private final TravelerProfileService profileService;

	@Autowired
	public StoryEndpoint(StoryService storyService, TravelerProfileService profileService) {
		this.storyService = storyService;
		this.profileService = profileService;
	}

	@GetMapping(value = "/{airportId}", produces = "application/json")
	public List<StoryDTO> getStories(@PathVariable Long airportId) {
		final Stories stories = storyService.getStoriesForAirport(new AirportId(airportId));
		return stories.map(story -> new StoryDTO(story, profileService.getProfile(story.getAuthorId())));
	}

	@PutMapping(value = "/{airportId}", produces = "application/json")
	public void addStory(@PathVariable Long airportId, AddStoryRequestDTO requestDTO) {
		storyService.addStory(requestDTO.toDomain(new AirportId(airportId)));
	}

	@PostMapping(value = "/{storyId}/{travelerId}", produces = "application/json")
	public void likeStory(@PathVariable Long storyId, @PathVariable Long travelerId) {
		storyService.likeStory(new StoryId(storyId), new TravelerId(travelerId));
	}

}
