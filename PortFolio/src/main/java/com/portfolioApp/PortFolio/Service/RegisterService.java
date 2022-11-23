package com.portfolioApp.PortFolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolioApp.PortFolio.Entity.Acheievements;
import com.portfolioApp.PortFolio.Entity.Authority;
import com.portfolioApp.PortFolio.Entity.PortFolioDetails;
import com.portfolioApp.PortFolio.Entity.Profile;
import com.portfolioApp.PortFolio.Entity.Projects;
import com.portfolioApp.PortFolio.Entity.Skills;
import com.portfolioApp.PortFolio.Entity.Studies;
import com.portfolioApp.PortFolio.Repository.AchievementRepository;
import com.portfolioApp.PortFolio.Repository.AuthorityRepository;
import com.portfolioApp.PortFolio.Repository.PortFolioDetailsRepository;
import com.portfolioApp.PortFolio.Repository.ProfileRepository;
import com.portfolioApp.PortFolio.Repository.ProjectsRepository;
import com.portfolioApp.PortFolio.Repository.SkillsRepository;
import com.portfolioApp.PortFolio.Repository.StudiesRepository;

@Service
public class RegisterService {
	
	@Autowired
	public AuthorityRepository authorityRepo;
	
	@Autowired 
	public ProfileRepository profileRepo;
	
	@Autowired
	public ProjectsRepository projectsRepo;
	
	@Autowired
	public StudiesRepository studiesRepo;
	
	@Autowired
	public SkillsRepository skillsRepo;
	
	@Autowired
	public AchievementRepository achievementRepo;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public PortFolioDetailsRepository portRepo;
	
	public void saveAuthority() {
		
		authorityRepo.deleteAll();
		Authority authority1=new Authority();
		authority1.setId(1L);
		authority1.setName("USER");
		authorityRepo.save(authority1);
		Authority authority2=new Authority();
		authority2.setId(2L);
		authority2.setName("ADMIN");
		authorityRepo.save(authority2); 
		
	}
	
	public Profile saveProfile(Profile profile) {
		
		List<Profile> allProfiles=profileRepo.findAll();
		Profile profiles=new Profile();
		int p=1;
		for(Profile register : allProfiles) {
			if(register.getEmail().equals(profile.getEmail())) {
				p=0;
			}
		}
		if(p==1) {
			String password=profile.getPassword();
			String hashedPassword=passwordEncoder.encode(password);
			profile.setPassword(hashedPassword);
			profile.setAuthority(new Authority(1,"USER"));
			profiles=profileRepo.save(profile);
		}
		return profiles;
	}
	
	public PortFolioDetails savePortFolioDetails(PortFolioDetails port,Authentication authentication) {
		
		List<Profile> profiles=profileRepo.findAll();
		
		for(Profile profile:profiles) {
			if(profile.getEmail().equals(authentication.getName())) {
				port.setName(profile.getName());
				port.setEmail(profile.getEmail());
				port.setProfile(profile);
				
			}
		}
		
		for(Skills skill : port.getSkills()) {
			skill.setPortfolioDetails(port);
		}
		
		for(Acheievements ach: port.getAchievements()) {
			ach.setPortfolioList(port);
		}
		
		for(Projects project : port.getProjects()) {
			project.setPortfolios(port);
		}
		
		for(Studies studies:port.getStudies()) {
			studies.setPortfolio(port);
		}
		
		if(port.getEmail()!=null) {
			System.out.print(port.getName());
			PortFolioDetails portFolio=portRepo.save(port);
			return portFolio;
		}
		else {
			System.out.print(port.getName());
			return new PortFolioDetails();
		}
	}
	
	public PortFolioDetails getPortfolio(String email) {
		
		List<PortFolioDetails> getPortFolio=portRepo.findAll();
		PortFolioDetails portDetails=new PortFolioDetails();
		
		for(PortFolioDetails port : getPortFolio) {
			if(port.getEmail().equals(email)){
				portDetails=port;
			}
		}
		return portDetails;
	}
	
	public PortFolioDetails updatePortfolio(PortFolioDetails portfolio,String email) {
		
		List<PortFolioDetails> allPortfolio = portRepo.findAll();
		PortFolioDetails updatedOne=new PortFolioDetails();
		
		List<Profile> profiles=profileRepo.findAll();
		
		for(Profile profile:profiles) {
			if(profile.getEmail().equals(email)) {
				portfolio.setName(profile.getName());
				portfolio.setEmail(profile.getEmail());
				portfolio.setProfile(profile);
				
			}
		
		}
		
		for(Skills skill : portfolio.getSkills()) {
			skill.setPortfolioDetails(portfolio);
		}
		
		for(Acheievements ach: portfolio.getAchievements()) {
			ach.setPortfolioList(portfolio);
		}
		
		for(Projects project : portfolio.getProjects()) {
			project.setPortfolios(portfolio);
		}
		
		for(Studies studies:portfolio.getStudies()) {
			studies.setPortfolio(portfolio);
		}
		
		
		for(PortFolioDetails port : allPortfolio) {
			if(port.getEmail().equals(email)) {
				portRepo.deleteById(port.getId());
				updatedOne=portRepo.save(portfolio);
			}
		}
		return updatedOne;
		
	}
	public PortFolioDetails alreadyFound(Authentication authentication) {
		List<PortFolioDetails> portFolio=portRepo.findAll();
		PortFolioDetails portName=new PortFolioDetails();
		for(PortFolioDetails port:portFolio) {
			if(port.getEmail().equals(authentication.getName())) {
				portName=port;
			}
		}
		return portName;
	}
	
}
