package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.gcu.data.AccountBusinessService;
import com.gcu.data.CustomSuccessHandler;

/**
 * The Class SecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{

	/**
	 * Filter chain.
	 *
	 * @param http the http
	 * @return the security filter chain
	 * @throws Exception the exception
	 */
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
		//added /services/ to basic authentication for API
		.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/services/**").authenticated()
			.and()
		.authorizeRequests()
			.antMatchers("/trainer/**").hasRole("trainer")
			.antMatchers("/user/**").hasAnyRole("client", "trainer")
			.and()
		.authorizeRequests()
			.antMatchers("/", "/images/**", "/register/**", "/doRegisterClient", "/doRegisterTrainer").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.successHandler(myAuthenticationSuccessHandler())
			.and()
		.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutSuccessUrl("/login");
		
		return http.build();
	}
	
	/** The password encoder. */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/** The service. Constructor injection*/
	@Autowired
	AccountBusinessService service;
	
	/**
	 * Password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * My authentication success handler.
	 *
	 * @return the authentication success handler
	 */
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new CustomSuccessHandler();
	}
	
	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
	}
}
