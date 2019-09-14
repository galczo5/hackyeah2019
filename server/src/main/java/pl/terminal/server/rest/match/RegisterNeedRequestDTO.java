package pl.terminal.server.rest.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterNeedRequestDTO {

	private Long traveler;

	private Set<Need> needs;

	private Long airport;

	private LocalDateTime availableFrom;

	private LocalDateTime availableTo;

	public RegisterNeedRequest toDomain() {
		return new RegisterNeedRequest(
				new TravelerId(traveler),
				needs,
				new AirportId(airport),
				new TimeAvailability(availableFrom, availableTo)
		);
	}
}
