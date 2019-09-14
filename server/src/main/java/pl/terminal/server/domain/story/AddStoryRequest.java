package pl.terminal.server.domain.story;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.traveler.TravelerId;

@AllArgsConstructor
@Getter
public class AddStoryRequest {

	private final TravelerId authorId;

	private final AirportId airportId;

	private final Title title;

	private final Content content;

}
