package pl.terminal.server.domain.story;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.traveler.TravelerId;

@Getter
@AllArgsConstructor
public class Story {

	private final StoryId storyId;

	private final TravelerId authorId;

	private final AirportId airportId;

	private final Title title;

	private final Content content;

	private final Set<TravelerId> likers;

	public void like(TravelerId liker) {
		likers.add(liker);
	}

	public int getNumberOfLikes() {
		return likers.size();

	}
}
