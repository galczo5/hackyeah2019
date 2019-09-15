package pl.terminal.server.application.match;

import org.springframework.stereotype.Service;
import pl.terminal.server.domain.match.password.MatchPasswordGenerator;
import pl.terminal.server.domain.match.password.MatchPasswordRequest;
import pl.terminal.server.domain.match.password.MatchPasswordResponse;

@Service
public class MatchPasswordService implements MatchPasswordGenerator {
    @Override
    public MatchPasswordResponse generatePassword(MatchPasswordRequest matchPasswordRequest) {
        return MatchPasswordResponse.builder()
                .password(matchPasswordRequest.getPassword())
                .build();
    }
}
