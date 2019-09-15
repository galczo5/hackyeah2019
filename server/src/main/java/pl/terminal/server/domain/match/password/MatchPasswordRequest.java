package pl.terminal.server.domain.match.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchPasswordRequest {
    private String password;
    private Long match;
    public static MatchPasswordRequest empty() {
        return new MatchPasswordRequest();
    }
}
