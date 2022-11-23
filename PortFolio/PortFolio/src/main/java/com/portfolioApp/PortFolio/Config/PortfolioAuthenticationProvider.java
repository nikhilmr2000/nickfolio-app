package com.portfolioApp.PortFolio.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.portfolioApp.PortFolio.Entity.Profile;
import com.portfolioApp.PortFolio.Repository.ProfileRepository;

@Component
public class PortfolioAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	public ProfileRepository profiles;
	
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String email=authentication.getName();
		String password=authentication.getCredentials().toString();
		
		List<Profile> profile=profiles.findAll();
		Profile currentUser=new Profile();
		
		for(Profile user : profile) {
			if(user.getEmail().equals(email)) {
				currentUser=user;
			}
		}
		
		if(currentUser.getEmail()!=null) {
			if(passwordEncoder.matches(password,currentUser.getPassword())) {
				List<GrantedAuthority> authorities=new 	ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(currentUser.getAuthority().getName()));
				return new UsernamePasswordAuthenticationToken(email,password,authorities);
			}
			else {
				throw new BadCredentialsException("Invalid Password");
			}
		}
		else {
			throw new BadCredentialsException("No such Profile");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
