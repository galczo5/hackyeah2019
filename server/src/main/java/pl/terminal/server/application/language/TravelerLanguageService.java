package pl.terminal.server.application.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.terminal.server.domain.TravelerId;
import pl.terminal.server.domain.language.Language;
import pl.terminal.server.domain.language.TravelerLanguageRepository;
import pl.terminal.server.domain.language.TravelerLanguageSet;

@Service
public class TravelerLanguageService {

	private final TravelerLanguageRepository travelerLanguageRepository;

	@Autowired
	public TravelerLanguageService(TravelerLanguageRepository travelerLanguageRepository) {
		this.travelerLanguageRepository = travelerLanguageRepository;
	}

	public void addLanguage(TravelerId travelerId, Language language) {
		final TravelerLanguageSet languageSet = travelerLanguageRepository
				.getLanguagesFor(travelerId)
				.addLanguage(language);
		travelerLanguageRepository.updateLanguages(languageSet);
	}

	public TravelerLanguageSet getLanguages(TravelerId travelerId) {
		return travelerLanguageRepository.getLanguagesFor(travelerId);
	}
}
