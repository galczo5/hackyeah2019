package pl.terminal.server.infrastructure.need;

import org.springframework.stereotype.Service;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.match.password.MatchPasswordGenerator;
import pl.terminal.server.domain.match.password.MatchPasswordRequest;
import pl.terminal.server.domain.need.*;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.infrastructure.airport.AirportsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaNeedService implements NeedService {

    private final JpaNeedEventRepository jpaNeedRepository;

    private final JpaAcceptNeedEventRepository jpaAcceptNeedEventRepository;

    private final MatchPasswordGenerator matchPasswordGenerator;

    private final AirportsService airportsService;

    public JpaNeedService(JpaNeedEventRepository jpaNeedRepository, JpaAcceptNeedEventRepository jpaAcceptNeedEventRepository, MatchPasswordGenerator matchPasswordGenerator, AirportsService airportsService) {
        this.jpaNeedRepository = jpaNeedRepository;
        this.jpaAcceptNeedEventRepository = jpaAcceptNeedEventRepository;
        this.matchPasswordGenerator = matchPasswordGenerator;
        this.airportsService = airportsService;
    }

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

        JpaMatchNeedEvent acceptNeedEvent = JpaMatchNeedEvent.builder()
                .needRequestId(needRequest.getId())
                .password(matchPasswordGenerator.generatePassword(MatchPasswordRequest.empty()).getPassword())
                .matchPassword(matchPasswordGenerator.generatePassword(MatchPasswordRequest.empty()).getPassword())
                .matchNeedRequestId(matchNeedRequest.getId())
                .needMatchStatus(NeedMatchStatus.ACCEPTED)
                .build();

        JpaMatchNeedEvent persistedAcceptEvent = jpaAcceptNeedEventRepository.save(acceptNeedEvent);

        Airport airport = airportsService.getAirportById(new AirportId(needRequest.getAirportId()));

        return MatchAcceptResult.builder()
                .id(persistedAcceptEvent.getId())
                .meetingPointName(airport.getMeetingPlace().getName())
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
