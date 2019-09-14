package pl.terminal.server.infrastructure.need;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.*;
import pl.terminal.server.domain.traveler.TravelerId;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaNeedService implements NeedService {

    @Autowired
    private JpaNeedEventRepository jpaNeedRepository;

    @Autowired
    private JpaAcceptNeedEventRepository jpaAcceptNeedEventRepository;


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
                .map(this::toNeedRequest)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId) {
        return jpaNeedRepository.findAllByAirportId(airportId.getAirportId())
                .stream()
                .map(this::toNeedRequest)
                .collect(Collectors.toList());
    }

    @Override
    public MatchAcceptResult createMatchAccept(NeedRequestId needRequestId, NeedRequestId matchAcceptId) {
        JpaNeedEvent needRequest = jpaNeedRepository.findById(needRequestId.getId()).orElseThrow(IllegalAccessError::new);
        JpaNeedEvent matchNeedRequest = jpaNeedRepository.findById(matchAcceptId.getId()).orElseThrow(IllegalAccessError::new);

        JpaAcceptNeedEvent acceptNeedEvent = JpaAcceptNeedEvent.builder()
                .needRequestId(needRequest.getId())
                .matchNeedRequestId(matchNeedRequest.getId())
                .needMatchStatus(NeedMatchStatus.ACCEPTED)
                .build();

        JpaAcceptNeedEvent persistedAcceptEvent = jpaAcceptNeedEventRepository.save(acceptNeedEvent);

        return MatchAcceptResult.builder()
                .id(persistedAcceptEvent.getId())
                .status(persistedAcceptEvent.getNeedMatchStatus())
                .build();
    }

    private NeedRequest toNeedRequest(JpaNeedEvent jpaNeedEvent) {
        return NeedRequest.builder()
                .needRequestId(new NeedRequestId(jpaNeedEvent.getId()))
                .airportId(new AirportId(jpaNeedEvent.getAirportId()))
                .needs(jpaNeedEvent.getNeeds())
                .timeAvailability(new TimeAvailability(jpaNeedEvent.getAvailableFrom(), jpaNeedEvent.getAvailableTo()))
                .travelerId(new TravelerId(jpaNeedEvent.getTravelerId()))
                .build();
    }
}
