package pl.terminal.server.domain;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Traveler {

	private final TravelerId id;

	private final List<Traveler> friends = new ArrayList<>();

	public Traveler(TravelerId id) {
		this.id = id;
	}

	public void addFriend(Traveler traveler) {
		friends.add(traveler);

		// other side has to know about friendship
		traveler.addFriend(this);
	}

	public void removeFriend(Traveler traveler) {
		friends.remove(traveler);

		// no friendship anymore :(
		traveler.removeFriend(this);
	}
}
