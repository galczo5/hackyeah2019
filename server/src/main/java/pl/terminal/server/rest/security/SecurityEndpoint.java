package pl.terminal.server.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public void login(@RequestBody LoginRequestDTO requestDTO) {
		securityService.login(requestDTO.username, requestDTO.password);
	}

	@GetMapping("/logged")
	public Long getLoggedUserId() {
		return securityService.findLoggedInUserId();
	}

}
