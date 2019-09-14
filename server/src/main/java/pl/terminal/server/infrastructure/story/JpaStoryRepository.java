package pl.terminal.server.infrastructure.story;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.story.AddStoryRequest;
import pl.terminal.server.domain.story.Stories;
import pl.terminal.server.domain.story.Story;
import pl.terminal.server.domain.story.StoryId;
import pl.terminal.server.domain.story.StoryRepository;

@Service
public class JpaStoryRepository implements StoryRepository {

	private final JpaStoryCrudRepository jpaRepository;

	public JpaStoryRepository(JpaStoryCrudRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Stories findByAirportId(AirportId airportId) {
		List<Story> stories = jpaRepository.findByAirportId(airportId.getAirportId()).stream().map(JpaStory::toDomain).collect(Collectors.toList());
		return new Stories(stories);
	}

	@Override
	public void addStory(AddStoryRequest request) {
		final JpaStory jpaStory = new JpaStory(request);
		jpaRepository.save(jpaStory);
	}

	@Override
	public Optional<Story> findStoryById(StoryId storyId) {
		return jpaRepository.findById(storyId.getId())
				.map(JpaStory::toDomain);
	}

	@Override
	public void updateStory(Story story) {
		final JpaStory jpaStory = new JpaStory(story);
		jpaRepository.save(jpaStory);
	}

}
