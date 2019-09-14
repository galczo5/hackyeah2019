package pl.terminal.server.infrastructure.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.terminal.server.domain.event.EventType;

import java.util.Set;

@Repository
public interface TravelerEventRepository extends CrudRepository<JpaTravelerEvent, Long> {
    Set<JpaTravelerEvent> findAllByEventType(EventType eventType);
}
