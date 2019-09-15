package pl.terminal.server.application.need;

import java.util.List;
import java.util.Set;
import pl.terminal.server.application.match.MatchRemoveRequest;
import pl.terminal.server.application.match.MatchRemoveResponse;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.match.password.MatchPasswordRequest;
import pl.terminal.server.domain.need.MatchAcceptResult;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.traveler.TravelerId;

public interface NeedService {

	NeedRequestId registerNeed(RegisterNeedRequest request);

	NeedRequest findNeedRequest(NeedRequestId requestId);

	List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId, NeedRequestId toExclude);

	MatchAcceptResult createMatchAccept(NeedRequestId needRequestId, NeedRequestId matchAcceptId);

    MatchRemoveResponse removeAcceptedMatch(MatchRemoveRequest matchRemoveRequest);

	Set<NeedRequest> findNeedRequestsByTraveler(TravelerId travelerId);

	MatchAcceptResult confirmMatch(MatchPasswordRequest acceptMatchRequest);

	List<NeedRequest> findConfirmedMatchedNeeds(TravelerId travelerId);
}
