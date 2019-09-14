package pl.terminal.server.infrastructure.need;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

@Service
public class JpaNeedService implements NeedService {

    @Autowired
    private JpaNeedEventRepository jpaNeedRepository;

    @Override
    public NeedRequestId registerNeed(RegisterNeedRequest request) {
        JpaNeedEvent jpaNeedEvent = JpaNeedEvent
                .builder()
                .airportId(request.getAirportId().getAirportId())
                .needs(request.getNeeds())
                .travelerId(request.getTravelerId().getId())
                .build();

        JpaNeedEvent event = jpaNeedRepository.save(jpaNeedEvent);

        return NeedRequestId
                .builder()
                .id(event.getId())
                .build();
    }

    @Override
    public NeedRequest findNeedRequest(NeedRequestId requestId) {
        return jpaNeedRepository.findById(requestId.getId())
                .map(jpaNeedEvent -> NeedRequest.builder()
                        .airportId(new AirportId(jpaNeedEvent.getAirportId()))
                        .needs(jpaNeedEvent.getNeeds())
						.timeAvailability(new TimeAvailability(jpaNeedEvent.getAvailableFrom(), jpaNeedEvent.getAvailableTo()))
                        .travelerId(new TravelerId(jpaNeedEvent.getTravelerId()))
                        .build())
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId) {
        return null;
    }
}
