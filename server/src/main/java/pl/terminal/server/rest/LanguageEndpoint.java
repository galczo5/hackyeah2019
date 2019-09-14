package pl.terminal.server.rest;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.terminal.server.application.language.TravelerLanguageService;
import pl.terminal.server.domain.TravelerId;
import pl.terminal.server.domain.language.Language;

@RestController
@RequestMapping("languages")
public class LanguageEndpoint {

	private final TravelerLanguageService languageService;

	@Autowired
	public LanguageEndpoint(TravelerLanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping(value = "/{travelerId}", produces = "application/json")
	public Set<Language> getLanguages(@PathVariable String travelerId) {
		return languageService.getLanguages(new TravelerId(travelerId)).getLanguagesAsSet();
	}


	@PostMapping(value = "/{travelerId}")
	public void addLanguage(@PathVariable String travelerId, @RequestBody Language language) {
		languageService.addLanguage(new TravelerId(travelerId), language);
	}


}
