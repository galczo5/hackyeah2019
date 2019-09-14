package pl.terminal.server.domain.language;

import pl.terminal.server.domain.TravelerId;

public interface TravelerLanguageRepository {

	TravelerLanguageSet getLanguagesFor(TravelerId travelerId);

	void updateLanguages(TravelerLanguageSet languageSet);
}
