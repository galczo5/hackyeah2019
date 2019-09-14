package pl.terminal.server.domain.need;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchAcceptResult {
    private Long id;
    private NeedMatchStatus status;
    private String meetingPointName;
}
