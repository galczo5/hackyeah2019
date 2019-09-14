package pl.terminal.server.domain.traveler.profile.languages;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import pl.terminal.server.domain.traveler.TravelerId;

public class Languages {

	private final Set<Language> languages;

	public Languages(Set<Language> languages) {
		this.languages = languages;
	}

	public static Languages empty(TravelerId travelerId) {
		return new Languages(Collections.emptySet());
	}

	public Languages addLanguage(Language language) {
		final Set<Language> languages = new HashSet<>(this.languages);
		languages.add(language);
		return new Languages(languages);
	}

	public Set<Language> getAsSet() {
		return new HashSet<>(languages);
	}
}
