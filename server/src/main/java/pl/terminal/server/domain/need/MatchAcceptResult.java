package pl.terminal.server.domain.need;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.terminal.server.domain.airport.MeetingPoint;
import pl.terminal.server.infrastructure.need.MatchId;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchAcceptResult {
    private MatchId id;
    private NeedMatchStatus status;
    private MeetingPoint meetingPoint;
}
