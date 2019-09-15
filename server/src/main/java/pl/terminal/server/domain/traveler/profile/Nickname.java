package pl.terminal.server.domain.traveler.profile;

import org.apache.commons.lang3.StringUtils;

public class Nickname {

	private String nickname;

	public Nickname(String nickname) {

		this.nickname = nickname;
	}

	public static Nickname empty() {

		return new Nickname(StringUtils.EMPTY);
	}

	public String getInternal() {
		return nickname;
	}
}
