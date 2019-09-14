package pl.terminal.server.rest.events.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.terminal.server.domain.event.EventType;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEventRequest {
    private String user;
    private EventType eventType;
}
