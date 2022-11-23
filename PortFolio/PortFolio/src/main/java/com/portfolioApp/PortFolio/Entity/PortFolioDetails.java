package com.portfolioApp.PortFolio.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity()
@Table(name="PortfolioDetails")
public class PortFolioDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="email")
	public String email;
	
	@Column(name="tag")
	public String tag;
	
	@Column(name="description")
	public String description;
	
	@Column(name="contact")
	public String contact;
	
	@OneToMany(targetEntity=Studies.class,mappedBy="portfolio" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Studies> studies=new ArrayList<>();
	
	@OneToMany(targetEntity=Projects.class,mappedBy="portfolios",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Projects> projects=new ArrayList<>();
	
	//ACHIEVEMENTS
	@OneToMany(targetEntity=Acheievements.class,mappedBy="portfolioList",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Acheievements> achievements=new ArrayList<>();
	
	@OneToMany(targetEntity=Skills.class,mappedBy="portfolioDetails",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Skills> skills=new ArrayList<>();
	
	@OneToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;

	public PortFolioDetails(long id, String name, String email, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}

	public PortFolioDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Studies> getStudies() {
		return studies;
	}

	public void setStudies(List<Studies> studies) {
		this.studies = studies;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	
	
	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public List<Acheievements> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Acheievements> achievements) {
		this.achievements = achievements;
	}
	

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "PortFolioDetails [id=" + id + ", name=" + name + ", email=" + email + ", studies=" + studies
				+ ", contact=" + contact + "]";
	}
	
	
	
}
