package pl.terminal.server.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
		SessionId token = securityService.login(requestDTO.username, requestDTO.password);
		return token;
	}

	@GetMapping("/logged")
	public Long getLoggedUserId() {
		return securityService.findLoggedInUserId();
	}

}
