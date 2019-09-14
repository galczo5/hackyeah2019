package pl.terminal.server.infrastructure.need;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JpaNeedEventRepository extends CrudRepository<JpaNeedEvent, Long> {
    Set<JpaNeedEvent> findAllByAirportId(Long airportId);
}
