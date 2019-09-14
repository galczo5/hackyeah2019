package pl.terminal.server.application.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.story.AddStoryRequest;
import pl.terminal.server.domain.story.Stories;
import pl.terminal.server.domain.story.StoryId;
import pl.terminal.server.domain.story.StoryRepository;
import pl.terminal.server.domain.traveler.TravelerId;

@Service
public class StoryService {

	@Autowired
	private final StoryRepository storyRepository;

	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}

	public Stories getStoriesForAirport(AirportId airportId) {
		return storyRepository.findByAirportId(airportId);
	}

	public void addStory(AddStoryRequest request) {
		storyRepository.addStory(request);
	}

	public void likeStory(StoryId storyId, TravelerId liker) {
		storyRepository.findStoryById(storyId).ifPresent(
				story -> {
					story.like(liker);
					storyRepository.updateStory(story);
				}
		);
	}
}
