package pl.terminal.server.domain.story;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Content {

	private final String content;

	public String asString() {
		return this.content;
	}
}
