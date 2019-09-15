package pl.terminal.server.infrastructure.security;

import pl.terminal.server.rest.security.SessionId;

public interface SecurityService {

	Long findLoggedInUserId();

	SessionId login(String username, String password);

	void resolveTokenToUser(String token);

	String generateToken(String username);

}
