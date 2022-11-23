package com.portfolioApp.PortFolio.Config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class PortfolioSecurityConfiguration {
	
	@Bean
	SecurityFilterChain defaultSecurityChainFilter(HttpSecurity http) throws Exception{
		
		http.cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cors=new CorsConfiguration();
				cors.setAllowedOriginPatterns(Collections.singletonList("*"));
				cors.setAllowedMethods(Collections.singletonList("*"));
				cors.setAllowedHeaders(Collections.singletonList("*"));
				cors.setAllowCredentials(true);
				cors.setMaxAge(6000L);
				return cors;
			}
		}).and()
		.csrf().disable()//ignoringAntMatchers("/register","/portFolio/portfolioDetails","/portFolio/portfolioDetails/*")
		//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.authorizeHttpRequests()
		.antMatchers("/portFolio/portfolioDetails").hasAuthority("USER")
		.antMatchers("/portFolio","/currentUser","/getPortDetails").authenticated()
		.antMatchers("/register","/portFolio/portfolioDetails/*").permitAll()
		.and().httpBasic()
		.and().formLogin();
	
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
