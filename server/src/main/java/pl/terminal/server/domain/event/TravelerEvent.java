package pl.terminal.server.domain.event;

import lombok.Builder;
import lombok.Data;
import pl.terminal.server.domain.TravelerId;

@Data
@Builder
public class TravelerEvent {
    private TravelerId travelerId;
    private EventType eventType;
    private String eventData;
}
