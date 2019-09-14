package pl.terminal.server.infrastructure.language;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.TravelerId;
import pl.terminal.server.domain.language.TravelerLanguageRepository;
import pl.terminal.server.domain.language.TravelerLanguageSet;

@Service
public class JpaTravelerLanguageRepository implements TravelerLanguageRepository {

	private final JpaTravelerLanguageCrudRepository jpaRepository;

	@Autowired
	public JpaTravelerLanguageRepository(JpaTravelerLanguageCrudRepository jpaRepository) {
		this.jpaRepository = jpaRepository;

	}

	@Override
	public TravelerLanguageSet getLanguagesFor(TravelerId travelerId) {
		final List<TravelerLanguageJpa> languages = jpaRepository.findByTravelerId(travelerId.getId());
		return new TravelerLanguageSet(
				travelerId,
				languages.stream().map(TravelerLanguageJpa::getLanguage).collect(Collectors.toSet())
		);
	}

	@Override
	public void updateLanguages(TravelerLanguageSet languageSet) {
		final TravelerId travelerId = languageSet.getTravelerId();
		jpaRepository.removeByTravelerId(travelerId.getId());
		languageSet.getLanguagesAsSet().stream()
				.map(language -> new TravelerLanguageJpa(travelerId, language))
				.forEach(jpaRepository::save);
	}
}
