package com.curso.spring.seguridad.config;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth)
	 * throws Exception { // No invocar el super // super.configure(auth);
	 * System.out.println("Config Autenticacion");
	 * auth.inMemoryAuthentication().withUser("Fernando").password("1234").roles
	 * ("AGENTE", "LECTOR");
	 * auth.inMemoryAuthentication().withUser("Mulder").password("fox").roles(
	 * "AGENTE_ESPECIAL");
	 * auth.inMemoryAuthentication().withUser("Scully").password("dana").roles(
	 * "AGENTE_ESPECIAL");
	 * auth.inMemoryAuthentication().withUser("Skinner").password("walter").
	 * roles("DIRECTOR"); }
	 */

	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userDetailsService()); }
	 * 
	 * public UserDetailsService userDetailsService() { Properties usuarios =
	 * new Properties(); usuarios.put("Fernando",
	 * "1234,ROLE_AGENTE,LECTOR,enabled"); usuarios.put("Mulder",
	 * "fox,ROLE_AGENTE_ESPECIAL,enabled"); usuarios.put("Scully",
	 * "dana,ROLE_AGENTE_ESPECIAL,enabled"); usuarios.put("Skinner",
	 * "walter,ROLE_DIRECTOR,enabled"); return new
	 * InMemoryUserDetailsManager(usuarios); }
	 */

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("fox");
		System.out.println(encode + ": " + encoder.matches("fox", encode));
		System.out.println("$2a$10$Q7y.qrgcn9CNkpf.7LKcKOBvHAmmzA.Wvim5a042zpgWygklOyjY2: " + encoder.matches("fox", "$2a$10$Q7y.qrgcn9CNkpf.7LKcKOBvHAmmzA.Wvim5a042zpgWygklOyjY2"));
		auth.userDetailsService(userDetailsService()).passwordEncoder(encoder);
	}

	public UserDetailsService userDetailsService() {
		Properties usuarios = new Properties();
		usuarios.put("Fernando", "$2a$10$SMPYtil7Hs2.cV7nrMjrM.dRAkuoLdYM8NdVrF.GeHfs/MrzcQ/zi,ROLE_AGENTE,enabled");
		usuarios.put("Mulder", "$2a$10$Q7y.qrgcn9CNkpf.7LKcKOBvHAmmzA.Wvim5a042zpgWygklOyjY2,ROLE_AGENTE_ESPECIAL,enabled");
		usuarios.put("Scully", "$2a$10$cbF5xp0grCOGcI6jZvPhA.asgmILATW1hNbM2MEqGJEFnRhhQd3ba,ROLE_AGENTE_ESPECIAL,enabled");
		usuarios.put("Skinner", "$2a$10$ZFtPIULMcxPe3r/5VunbVujMD7Lw8hkqAmJlxmK5Y1TK3L1bf8ULG,ROLE_DIRECTOR,enabled");
		return new InMemoryUserDetailsManager(usuarios);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/img/*").authenticated().antMatchers("/logout").authenticated()
				.antMatchers("/css/*").permitAll().antMatchers("/js/*").permitAll().antMatchers("/bienvenida")
				.access("hasAnyRole('LECTOR','AGENTE_ESPECIAL','DIRECTOR')").antMatchers("/**")
				.access("hasAnyRole('AGENTE_ESPECIAL','DIRECTOR')");
		http.formLogin();
		SimpleUrlLogoutSuccessHandler logoutSuccessHandler = new SimpleUrlLogoutSuccessHandler();
		logoutSuccessHandler.setDefaultTargetUrl("/css/main.css");
		http.logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true)
				.addLogoutHandler(new SecurityContextLogoutHandler())
				.addLogoutHandler(new CookieClearingLogoutHandler("JSESSIONID"))
				.logoutSuccessHandler(logoutSuccessHandler).and().csrf().disable();
	}

}
