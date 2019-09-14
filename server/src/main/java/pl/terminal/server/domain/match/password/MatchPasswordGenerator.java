package pl.terminal.server.domain.match.password;

public interface MatchPasswordGenerator {
    MatchPasswordResponse generatePassword(MatchPasswordRequest matchPasswordRequest);
}
