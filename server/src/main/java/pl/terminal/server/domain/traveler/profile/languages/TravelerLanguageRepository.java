package pl.terminal.server.domain.traveler.profile.languages;

import pl.terminal.server.domain.traveler.TravelerId;

public interface TravelerLanguageRepository {

	Languages getLanguagesFor(TravelerId travelerId);

	void updateLanguages(Languages languageSet);
}
