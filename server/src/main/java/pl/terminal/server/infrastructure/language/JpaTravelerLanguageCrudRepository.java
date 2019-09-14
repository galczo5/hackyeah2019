package pl.terminal.server.infrastructure.language;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface JpaTravelerLanguageCrudRepository extends CrudRepository<TravelerLanguageJpa, Long> {

	List<TravelerLanguageJpa> findByTravelerId(String travelerId);

	void removeByTravelerId(String travelerId);

}
