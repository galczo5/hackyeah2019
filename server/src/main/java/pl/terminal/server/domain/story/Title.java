package pl.terminal.server.domain.story;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Title {

	private String title;

	public String asString() {
		return title;
	}
}
