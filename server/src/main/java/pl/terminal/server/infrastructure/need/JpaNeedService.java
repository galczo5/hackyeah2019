package pl.terminal.server.infrastructure.need;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import pl.terminal.server.application.match.MatchRemoveRequest;
import pl.terminal.server.application.match.MatchRemoveResponse;
import pl.terminal.server.application.need.NeedService;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.match.password.MatchPasswordGenerator;
import pl.terminal.server.domain.match.password.MatchPasswordRequest;
import pl.terminal.server.domain.need.MatchAcceptResult;
import pl.terminal.server.domain.need.NeedMatchStatus;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.infrastructure.airport.AirportsService;

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
				.availableFrom(request.getTimeAvailability().getFrom())
				.availableTo(request.getTimeAvailability().getTo())
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
    public List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId, NeedRequestId needRequestId) {
        return jpaNeedRepository.findAllByAirportIdAndIdNot(airportId.getAirportId(), needRequestId.getId())
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
                .id(new MatchId(persistedAcceptEvent.getId()))
                .meetingPoint(airport.getMeetingPoint())
                .status(persistedAcceptEvent.getNeedMatchStatus())
                .build();
    }

    @Override
    public MatchRemoveResponse removeAcceptedMatch(MatchRemoveRequest matchRemoveRequest) {
        JpaMatchNeedEvent match = jpaAcceptNeedEventRepository.findById(matchRemoveRequest.getMatchId().getId()).orElseThrow(IllegalArgumentException::new);
        jpaAcceptNeedEventRepository.delete(match);
        return new MatchRemoveResponse();
    }

	@Override
	public Set<NeedRequest> findNeedRequestsByTraveler(TravelerId travelerId) {
		return jpaNeedRepository.findAllByTravelerId(travelerId.getId()).stream().map(this::toNeedRequest).collect(Collectors.toSet());
	}

	@Override
    public MatchAcceptResult confirmMatch(MatchPasswordRequest acceptMatchRequest) {
        JpaMatchNeedEvent match = jpaAcceptNeedEventRepository.findById(acceptMatchRequest.getMatch()).orElseThrow(IllegalArgumentException::new);

        match.setNeedMatchStatus(NeedMatchStatus.CONFIRMED);
        jpaAcceptNeedEventRepository.save(match);

        return new MatchAcceptResult(
                new MatchId(match.getId()),
                NeedMatchStatus.CONFIRMED,
                null
        );
    }

	@Override
	public List<NeedRequest> findConfirmedMatchedNeeds(TravelerId travelerId) {
		return StreamSupport.stream(jpaAcceptNeedEventRepository.findAll().spliterator(), false)
				.filter(match ->
						jpaNeedRepository.findById(match.getNeedRequestId()).map(need -> need.getTravelerId().equals(travelerId.getId())).orElse(false)
				)
				.filter(event -> event.getNeedMatchStatus() == NeedMatchStatus.CONFIRMED)
				.map(JpaMatchNeedEvent::getMatchNeedRequestId)
				.map(jpaNeedRepository::findById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(this::toNeedRequest)
				.collect(Collectors.toList());
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
