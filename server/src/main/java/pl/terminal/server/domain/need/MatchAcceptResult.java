package pl.terminal.server.domain.need;

import lombok.*;
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
