package pl.terminal.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;


	@Autowired
	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//		http
		//				.authorizeRequests()
		//				.antMatchers("**/security/**").permitAll()
		//				.antMatchers(HttpMethod.POST, "**/security/**").permitAll()
		//				.anyRequest().authenticated()
		//				.and()
		//				.addFilterBefore((servletRequest, servletResponse, filterChain) -> {
		//					HttpServletRequest req = (HttpServletRequest)servletRequest;
		//					String authorization = req.getHeader("Authorization");
		//					String basicToken = authorization.split(" ")[1];
		//
		//					String decodedToken = new String(Base64.getDecoder().decode(basicToken.getBytes()));
		//					String[] tokenData = decodedToken.split(":");
		//
		//					UserDetails userDetails = userDetailsService.loadUserByUsername(tokenData[0]);
		//					if(userDetails != null) {
		//						UsernamePasswordAuthenticationToken springToken = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails
		//						.getAuthorities());
		//						SecurityContextHolder.getContext().setAuthentication(springToken);
		//					}
		//
		//					filterChain.doFilter(servletRequest, servletResponse);
		//
		//				}, UsernamePasswordAuthenticationFilter.class)
		//				.httpBasic().disable()
		//				.csrf().disable()
		//				.cors().disable()
		//				.logout().permitAll();
	}
}
