package pl.terminal.server.infrastructure.security;

public interface SecurityService {

	Long findLoggedInUserId();

	void login(String username, String password);
}
