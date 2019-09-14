package pl.terminal.server.infrastructure.need;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAcceptNeedEventRepository extends CrudRepository<JpaMatchNeedEvent, Long> {
}
