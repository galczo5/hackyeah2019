package pl.terminal.server.application.need;

import java.util.List;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;

public interface NeedService {

	NeedRequestId registerNeed(RegisterNeedRequest request);

	NeedRequest findNeedRequest(NeedRequestId requestId);

	List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId);
}
