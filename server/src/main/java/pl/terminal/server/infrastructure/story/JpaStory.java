package pl.terminal.server.infrastructure.story;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.story.AddStoryRequest;
import pl.terminal.server.domain.story.Content;
import pl.terminal.server.domain.story.Story;
import pl.terminal.server.domain.story.StoryId;
import pl.terminal.server.domain.story.Title;
import pl.terminal.server.domain.traveler.TravelerId;

@Entity
public class JpaStory {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String content;

	private Long airportId;

	private Long authorId;

	@ElementCollection
	@CollectionTable(name = "story_liker", joinColumns = @JoinColumn(name = "story_id"))
	private Set<Long> likers;

	public JpaStory(Story story) {
		this.id = story.getStoryId().getId();
		this.title = story.getTitle().asString();
		this.content = story.getContent().asString();
		this.airportId = story.getAirportId().getAirportId();
		this.authorId = story.getAuthorId().getId();
		this.likers = story.getLikers().stream().map(TravelerId::getId).collect(Collectors.toSet());
	}

	public JpaStory(AddStoryRequest request) {
		this.title = request.getTitle().asString();
		this.content = request.getContent().asString();
		this.airportId = request.getAirportId().getAirportId();
		this.authorId = request.getAuthorId().getId();
		this.likers = new HashSet<>();
	}

	public JpaStory() {
	}

	public Story toDomain() {
		return new Story(
				new StoryId(id),
				new TravelerId(authorId),
				new AirportId(airportId),
				new Title(title),
				new Content(content),
				likers.stream().map(TravelerId::new).collect(Collectors.toSet())
		);
	}
}
