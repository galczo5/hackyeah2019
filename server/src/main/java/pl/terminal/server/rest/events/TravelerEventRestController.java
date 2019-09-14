package pl.terminal.server.rest.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.domain.traveler.TravelerId;
import pl.terminal.server.domain.event.TravelerEventService;
import pl.terminal.server.rest.events.io.RegisterEventRequest;
import pl.terminal.server.rest.events.io.RegisterEventResponse;

@RestController("/api/events")
public class TravelerEventRestController {

    @Autowired
    private TravelerEventService travelerEventService;


}
