package com.portfolioApp.PortFolio.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="education")
public class Studies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column(name="institute")
	public String instituteName;
	
	@Column(name="class")
	public String branch;
	
	@Column(name="grade")
	public String grade;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="portfolio_id")
	public PortFolioDetails portfolio;

	public Studies(long id, String instituteName, String address, String grade, PortFolioDetails portfolio) {
		super();
		this.id = id;
		this.instituteName = instituteName;
		this.branch = address;
		this.grade = grade;
		this.portfolio = portfolio;
	}

	public Studies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String address) {
		this.branch = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public PortFolioDetails getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(PortFolioDetails portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "Studies [id=" + id + ", instituteName=" + instituteName + ", address=" + branch + ", grade=" + grade
				+ ", portfolio=" + portfolio + "]";
	}
	
	
	
}
