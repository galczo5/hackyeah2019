package pl.terminal.server.rest.match;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterNeedRequestDTO {

	private Set<Need> needs;

	private Long airport;

	private LocalDateTime availableFrom;

	private LocalDateTime availableTo;

	public RegisterNeedRequest toDomain(TravelerId travelerId) {
		return new RegisterNeedRequest(
				travelerId,
				needs,
				new AirportId(airport),
				new TimeAvailability(availableFrom, availableTo)
		);
	}
}
