package pl.terminal.server.domain.traveler.profile;

public class Nickname {

	private String nickname;

	public Nickname(String nickname) {

		this.nickname = nickname;
	}

	static Nickname empty() {

		return new Nickname("");
	}

	public String getInternal() {
		return nickname;
	}
}
