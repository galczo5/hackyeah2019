package pl.terminal.server.domain.language;

import java.util.HashSet;
import java.util.Set;
import pl.terminal.server.domain.TravelerId;

public class TravelerLanguageSet {

	private final TravelerId travelerId;

	private final Set<Language> languages;

	public TravelerLanguageSet(TravelerId travelerId, Set<Language> languages) {
		this.travelerId = travelerId;
		this.languages = languages;
	}

	public TravelerLanguageSet addLanguage(Language language) {
		final Set<Language> languages = new HashSet<>(this.languages);
		languages.add(language);
		return new TravelerLanguageSet(travelerId, languages);
	}

	public TravelerId getTravelerId() {
		return travelerId;
	}

	public Set<Language> getLanguagesAsSet() {
		return new HashSet<>(languages);
	}
}
