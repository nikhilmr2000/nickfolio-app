package com.portfolioApp.PortFolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolioApp.PortFolio.Entity.PortFolioDetails;
import com.portfolioApp.PortFolio.Entity.Profile;
import com.portfolioApp.PortFolio.Repository.PortFolioDetailsRepository;
import com.portfolioApp.PortFolio.Repository.ProfileRepository;
import com.portfolioApp.PortFolio.Service.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	public RegisterService registerService;
	
	@Autowired
	public ProfileRepository profileRepo;
	
	@Autowired
	public PortFolioDetailsRepository portRepo;
	
	
	
	@PostMapping("/register")	
	public Profile saveProfileDetails(@RequestBody Profile profile) {
		Profile profiles=registerService.saveProfile(profile);
		if(profiles==null) {
			return new Profile();
		}
		else {
			return profiles;
		}
	}
	
	@GetMapping("/portFolio")
	public Profile getLoggedUser(Authentication authentication) {
		List<Profile> profiles=profileRepo.findAll();
		Profile activeUser=new Profile();
		for(Profile profile:profiles) {
			if(profile.getEmail().equals(authentication.getName())) {
				activeUser=profile;
			}
		}
		return activeUser;
	}
	
	@PostMapping("/portFolio/portfolioDetails")
	public PortFolioDetails savePortFolioDetails(@RequestBody PortFolioDetails portFolioDetails,Authentication authentication) {
		
			PortFolioDetails portFolio = registerService.savePortFolioDetails(portFolioDetails,authentication);
			if(portFolio==null) {
				System.out.println("Bad");
				return new PortFolioDetails();
			}
			else {
				return portFolio;
			}
		
	}
	
	@PutMapping("/portFolio/portfolioDetails")
	public PortFolioDetails updatePortFolioDetails(@RequestBody PortFolioDetails portFolioDetails,Authentication authentication) {
		
			PortFolioDetails portFolio = registerService.updatePortfolio(portFolioDetails,authentication.getName());
			if(portFolio==null) {
				System.out.println("Bad");
				return new PortFolioDetails();
			}
			else {
				return portFolio;
			}
		
	}
	
	
	@GetMapping("/portFolio/portfolioDetails/{mail}")
	public PortFolioDetails getPortfolioDetails(@PathVariable String mail) {
		PortFolioDetails portDetails=registerService.getPortfolio(mail);
		if(portDetails!=null) {
			return portDetails;
		}
		else {
			return new PortFolioDetails();
		}
	}
	
	@GetMapping("/currentUser")
	public PortFolioDetails getCurrentUserPortFolio(Authentication authentication) {
		List<PortFolioDetails> details=portRepo.findAll();
		PortFolioDetails ports=new PortFolioDetails();
		for(PortFolioDetails port : details) {
			if(authentication.getName().equals(port.getEmail())) {
				ports=port;
			}
		}
		return ports;
	}
	
	@GetMapping("/getPortDetails")
	public PortFolioDetails getPortFolioDetails(Authentication authentication) {
		PortFolioDetails portValue=registerService.alreadyFound(authentication);
		return portValue;
	}
	
}
