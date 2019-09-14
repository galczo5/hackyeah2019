package pl.terminal.server.application.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.terminal.server.infrastructure.need.MatchId;

@Getter
@AllArgsConstructor
public class MatchRemoveRequest {

    private MatchId matchId;

}
