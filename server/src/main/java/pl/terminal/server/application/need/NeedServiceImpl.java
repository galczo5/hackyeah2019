package pl.terminal.server.application.need;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.NeedRequest;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;

@Service
public class NeedServiceImpl implements NeedService {

	@Override
	public NeedRequestId registerNeed(RegisterNeedRequest request) {
		return null;
	}

	@Override
	public NeedRequest findNeedRequest(NeedRequestId requestId) {
		return null;
	}

	@Override
	public List<NeedRequest> findActiveNeedRequestsByAirport(AirportId airportId) {
		return null;
	}
}
