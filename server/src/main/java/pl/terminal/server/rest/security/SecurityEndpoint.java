package pl.terminal.server.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import pl.terminal.server.infrastructure.security.SecurityService;

@RestController
@RequestMapping("api/security")
public class SecurityEndpoint {

	private final SecurityService securityService;

	@Autowired
	public SecurityEndpoint(SecurityService securityService) {
		this.securityService = securityService;
	}

	@PostMapping("/login")
	public SessionId login(@RequestBody LoginRequestDTO requestDTO) {
		securityService.login(requestDTO.username, requestDTO.password);
		return new SessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
	}

	@GetMapping("/logged")
	public Long getLoggedUserId() {
		return securityService.findLoggedInUserId();
	}

}
