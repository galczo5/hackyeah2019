package pl.terminal.server.infrastructure.need;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNeedEventRepository extends CrudRepository<JpaNeedEvent, Long> {
}
