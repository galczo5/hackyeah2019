package pl.terminal.server.domain.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingPoint {
    private String name;
    private String description;

    public static MeetingPoint empty() {
        return new MeetingPoint(StringUtils.EMPTY, StringUtils.EMPTY);
    }
}
