package pl.terminal.server.rest.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.domain.TravelerId;
import pl.terminal.server.domain.event.TravelerEventService;
import pl.terminal.server.rest.events.io.RegisterEventRequest;
import pl.terminal.server.rest.events.io.RegisterEventResponse;

@RestController("/api/events")
public class TravelerEventRestController {

    @Autowired
    private TravelerEventService travelerEventService;


    @PostMapping
    public ResponseEntity<RegisterEventResponse> registerEvent(@RequestBody RegisterEventRequest registerEventRequest) {
        travelerEventService.addTravelerEvent(new TravelerId(registerEventRequest.getUser()), null);
        return ResponseEntity.ok(null);
    }

//    @GetMapping
//    public ResponseEntity<RegisterEventResponse> getUserEvents() {
//
//    }

}
