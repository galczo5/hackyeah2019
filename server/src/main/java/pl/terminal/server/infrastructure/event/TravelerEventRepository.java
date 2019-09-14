package pl.terminal.server.infrastructure.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerEventRepository extends CrudRepository<JpaTravelerEvent, Long> {
}
