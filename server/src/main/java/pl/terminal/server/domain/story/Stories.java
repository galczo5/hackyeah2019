package pl.terminal.server.domain.story;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stories {

	private final List<Story> stories;

	public Stories(List<Story> stories) {
		this.stories = stories;
	}

	public <R> List<R> map(Function<? super Story, ? extends R> mapper) {
		return stories.stream().map(mapper).collect(Collectors.toList());
	}
}
