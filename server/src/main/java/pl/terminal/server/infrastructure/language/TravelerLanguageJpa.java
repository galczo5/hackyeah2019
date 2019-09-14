package pl.terminal.server.infrastructure.language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.validation.constraints.NotNull;
import pl.terminal.server.domain.TravelerId;
import pl.terminal.server.domain.language.Language;

@Entity
public class TravelerLanguageJpa {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String travelerId;

	@NotNull
	private Language language;

	public TravelerLanguageJpa(TravelerId travelerId, Language language) {
		this.travelerId = travelerId.getId();
		this.language = language;
	}

	public TravelerLanguageJpa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
