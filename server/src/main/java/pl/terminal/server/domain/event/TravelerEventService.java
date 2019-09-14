package pl.terminal.server.domain.event;

import pl.terminal.server.domain.traveler.TravelerId;

import java.util.Set;

public interface TravelerEventService {
    void addTravelerEvent(TravelerId travelerId, TravelerEvent event);
    Set<TravelerEvent> getTravelerEvents(TravelerId travelerId);
}
