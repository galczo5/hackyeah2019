package pl.terminal.server.domain.match.password;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MatchPasswordResponse {
    private String password;
}
