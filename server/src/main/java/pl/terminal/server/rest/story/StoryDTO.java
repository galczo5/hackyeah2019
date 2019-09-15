package pl.terminal.server.rest.story;

import pl.terminal.server.domain.story.Story;
import pl.terminal.server.domain.traveler.profile.TravelerProfile;
import pl.terminal.server.rest.traveler.profile.TravelerProfileDTO;

@SuppressWarnings("WeakerAccess")
public class StoryDTO {

	public Long id;

	public String content;

	public String title;

	public TravelerProfileDTO author;

	public int numberOfLikes;

	public StoryDTO(Story story, TravelerProfile profile) {
		this.id = story.getStoryId().getId();
		this.author = new TravelerProfileDTO(profile);
		this.title = story.getTitle().asString();
		this.content = story.getContent().asString();
		this.numberOfLikes = story.getNumberOfLikes();
	}
}
