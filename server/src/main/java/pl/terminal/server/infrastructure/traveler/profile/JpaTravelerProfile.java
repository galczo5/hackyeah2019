package pl.terminal.server.infrastructure.traveler.profile;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.terminal.server.domain.traveler.profile.languages.Language;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@Entity
public class JpaTravelerProfile {

	@Id
	private String travelerId;

	private String nickname;

	private Nationality nationality;

	@ElementCollection
	@CollectionTable(name = "traveler_languages", joinColumns = @JoinColumn(name = "traveler_id"))
	private Set<Language> languages;

	public JpaTravelerProfile() {
	}

	JpaTravelerProfile(String travelerId, String nickname, Nationality nationality, Set<Language> languages) {
		this.travelerId = travelerId;
		this.nickname = nickname;
		this.nationality = nationality;
		this.languages = languages;
	}

	public String getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}

	String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
}
