package pl.terminal.server.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.terminal.server.rest.security.SessionId;

import java.util.Base64;

@Service
public class SecurityServiceImpl implements SecurityService {

	private final AuthenticationManager authenticationManager;

	private final UserDetailsService userDetailsService;

	private final UserRepository userRepository;

	@Autowired
	public SecurityServiceImpl(AuthenticationManager authenticationManager,
			UserDetailsService userDetailsService,
			UserRepository userRepository) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.userRepository = userRepository;
	}

	@Override
	public Long findLoggedInUserId() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return userRepository.findByUsername(((UserDetails) userDetails).getUsername()).getId();
		}

		Object token = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(token instanceof UserDetails) {
			return userRepository.findByUsername(((UserDetails) token).getUsername()).getId();
		}

		return null;
	}

	public String generateToken(String username) {
		return Base64.getEncoder().encodeToString(username.getBytes());
	}

	public void resolveTokenToUser(String token) {
		String username = new String(Base64.getDecoder().decode(token.getBytes()));
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if(userDetails == null) {
			return;
		}
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

	}

	@Override
	public SessionId login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());
		usernamePasswordAuthenticationToken.setDetails(userDetails);
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			return new SessionId(this.generateToken(username));
		}

		throw new IllegalArgumentException();
	}
}
