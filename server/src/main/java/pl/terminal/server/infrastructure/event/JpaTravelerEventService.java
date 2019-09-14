package pl.terminal.server.infrastructure.event;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.event.EventId;
import pl.terminal.server.domain.event.EventType;
import pl.terminal.server.domain.event.TravelerEvent;
import pl.terminal.server.domain.event.TravelerEventService;
import pl.terminal.server.domain.traveler.TravelerId;

@Service
public class JpaTravelerEventService implements TravelerEventService {

    private final TravelerEventRepository travelerEventRepository;

    public JpaTravelerEventService(TravelerEventRepository travelerEventRepository) {
        this.travelerEventRepository = travelerEventRepository;
    }

    public Set<TravelerEvent> getEventsByType(EventType eventType) {
        return travelerEventRepository.findAllByEventType(eventType)
                .stream()
                .map(jpaTravelerEvent -> TravelerEvent
                    .builder()
                    .event(EventId.builder().id(jpaTravelerEvent.getId()).build())
                    .eventType(jpaTravelerEvent.getEventType())
                    .eventData(jpaTravelerEvent.getData())
                .build())
                .collect(Collectors.toSet());
    }

    @Override
    public TravelerEvent findEventById(EventId eventId) {
        return travelerEventRepository
                .findById(eventId.getId())
                .map(jpaEvent->TravelerEvent
                        .builder()
                        .travelerId(new TravelerId(jpaEvent.getTraveler()))
                        .eventType(jpaEvent.getEventType())
                        .eventData(jpaEvent.getData())
                        .build()
                )
				.orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public TravelerEvent addTravelerEvent(TravelerId travelerId, TravelerEvent event) {
        JpaTravelerEvent travelerEvent = travelerEventRepository.save(JpaTravelerEvent
                .builder()
                .eventType(event.getEventType())
                .traveler(event.getTravelerId().getId())
                .data(event.getEventData())
                .build());

        return TravelerEvent
                .builder()
                .event(EventId.builder().id(travelerEvent.getId()).build())
                .eventType(travelerEvent.getEventType())
                .eventData(travelerEvent.getData())
                .build();
    }

    @Override
    public Set<TravelerEvent> getTravelerEvents(TravelerId travelerId) {
        return null;
    }
}
