package pl.terminal.server.infrastructure.need;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNeedEventRepository extends CrudRepository<JpaNeedEvent, Long> {
    Set<JpaNeedEvent> findAllByAirportIdAndIdNot(Long airportId, Long needEventId);

	Set<JpaNeedEvent> findAllByTravelerId(Long travelerId);
}
