package pl.terminal.server.domain.story;

import java.util.Optional;
import pl.terminal.server.domain.airport.AirportId;

public interface StoryRepository {

	Stories findByAirportId(AirportId airportId);

	void addStory(AddStoryRequest request);

	Optional<Story> findStoryById(StoryId storyId);

	void updateStory(Story story);
}
