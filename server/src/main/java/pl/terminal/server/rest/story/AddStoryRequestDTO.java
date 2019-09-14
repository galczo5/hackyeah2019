package pl.terminal.server.rest.story;

import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.story.AddStoryRequest;
import pl.terminal.server.domain.story.Content;
import pl.terminal.server.domain.story.Title;
import pl.terminal.server.domain.traveler.TravelerId;

@SuppressWarnings("WeakerAccess")
public class AddStoryRequestDTO {

	public Long travelerId;

	public String title;

	public String content;

	public AddStoryRequest toDomain(AirportId airportId) {
		return new AddStoryRequest(
				new TravelerId(travelerId),
				airportId,
				new Title(title),
				new Content(content)
		);
	}
}
