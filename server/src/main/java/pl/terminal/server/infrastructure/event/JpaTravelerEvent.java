package pl.terminal.server.infrastructure.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import pl.terminal.server.domain.event.EventType;

@Table
@Entity
@Builder
@Getter
public class JpaTravelerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private Long traveler;

    private EventType eventType;

    private String data;

}
