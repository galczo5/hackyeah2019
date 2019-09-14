package pl.terminal.server.domain.event;

import lombok.Builder;
import lombok.Data;
import pl.terminal.server.domain.traveler.TravelerId;

@Data
@Builder
public class TravelerEvent {
    private EventId event;
    private TravelerId travelerId;
    private EventType eventType;
    private String eventData;
}
