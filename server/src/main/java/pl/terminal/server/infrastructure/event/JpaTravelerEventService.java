package pl.terminal.server.infrastructure.event;

import org.springframework.stereotype.Service;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.event.TravelerEvent;
import pl.terminal.server.domain.event.TravelerEventService;

import java.util.Set;

@Service
public class JpaTravelerEventService implements TravelerEventService {

    private final TravelerEventRepository travelerEventRepository;

    public JpaTravelerEventService(TravelerEventRepository travelerEventRepository) {
        this.travelerEventRepository = travelerEventRepository;
    }

    @Override
    public void addTravelerEvent(TravelerId travelerId, TravelerEvent event) {
        travelerEventRepository.save(JpaTravelerEvent
                .builder()
                .eventType(event.getEventType())
                .traveler(event.getTravelerId().getId())
                .data(event.getEventData())
                .build());
    }

    @Override
    public Set<TravelerEvent> getTravelerEvents(TravelerId travelerId) {
        return null;
    }
}
