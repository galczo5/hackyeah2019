package pl.terminal.server.application.need;

import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.MatchAcceptResult;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;

import java.util.List;

public interface NeedService {

	NeedRequestId registerNeed(RegisterNeedRequest request);

	NeedRequest findNeedRequest(NeedRequestId requestId);

	List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId);

	MatchAcceptResult createMatchAccept(NeedRequestId needRequestId, NeedRequestId matchAcceptId);
}
