package pl.terminal.server.application.match

import pl.terminal.server.application.need.NeedService
import pl.terminal.server.domain.airport.AirportId
import pl.terminal.server.domain.match.password.MatchPasswordRequest
import pl.terminal.server.domain.need.MatchAcceptResult
import pl.terminal.server.domain.need.NeedRequest
import pl.terminal.server.domain.need.NeedRequestId
import pl.terminal.server.domain.need.RegisterNeedRequest
import pl.terminal.server.domain.traveler.TravelerId

import java.util.concurrent.atomic.AtomicInteger

class MockNeedService implements NeedService {

	AtomicInteger atomicInteger = new AtomicInteger(0)

	Map<AirportId, List<NeedRequest>> needsByAirports = new HashMap<>()

	Map<NeedRequestId, NeedRequest> needs = new HashMap<>()


	@Override
	NeedRequestId registerNeed(RegisterNeedRequest request) {
		NeedRequestId requestId = new NeedRequestId(atomicInteger.incrementAndGet())
		NeedRequest needRequest = new NeedRequest(
				requestId,
				request.getTravelerId(),
				request.getNeeds(),
				request.getAirportId(),
				request.getTimeAvailability()
		)
		needsByAirports.putIfAbsent(needRequest.airportId, new ArrayList<NeedRequest>())
		needsByAirports.get(needRequest.airportId).add(needRequest);
		needs.put(requestId, needRequest)
		return requestId
	}

	@Override
	NeedRequest findNeedRequest(NeedRequestId requestId) {
		return needs.get(requestId)
	}

	@Override
	List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId, NeedRequestId needRequestId) {
		return needsByAirports.get(airportId)
	}

	@Override
	MatchAcceptResult createMatchAccept(NeedRequestId needRequestId, NeedRequestId matchAcceptId) {
		return null
	}

	@Override
	MatchRemoveResponse removeAcceptedMatch(MatchRemoveRequest matchRemoveRequest) {
		return null
	}

	@Override
	Set<NeedRequest> findNeedRequestsByTraveler(TravelerId travelerId) {
		return null
	}

	@Override
	MatchAcceptResult confirmMatch(MatchPasswordRequest acceptMatchRequest) {
		return null
	}

	@Override
	List<NeedRequest> findConfirmedMatchedNeeds(TravelerId travelerId) {
		return null
	}
}
