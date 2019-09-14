package pl.terminal.server.infrastructure.story;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface JpaStoryCrudRepository extends CrudRepository<JpaStory, Long> {

	List<JpaStory> findByAirportId(Long airportId);
}
