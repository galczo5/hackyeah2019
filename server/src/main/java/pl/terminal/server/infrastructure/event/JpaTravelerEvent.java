package pl.terminal.server.infrastructure.event;

import lombok.Builder;
import lombok.Getter;
import pl.terminal.server.domain.event.EventType;

import javax.persistence.*;

@Table
@Entity
@Builder
@Getter
public class JpaTravelerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String traveler;

    private EventType eventType;

    private String data;

}
