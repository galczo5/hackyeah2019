package pl.terminal.server.domain.traveler.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Avatar {

    private String avatar;

    public static Avatar empty() {
        return new Avatar("");
    }
}
