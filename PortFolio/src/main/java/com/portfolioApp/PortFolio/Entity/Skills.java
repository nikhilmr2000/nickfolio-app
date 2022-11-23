package com.portfolioApp.PortFolio.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="skills")
public class Skills {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="portfolioDetails_id")
	public PortFolioDetails portfolioDetails;

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

	public PortFolioDetails getPortfolioDetails() {
		return portfolioDetails;
	}

	public void setPortfolioDetails(PortFolioDetails portfolioDetails) {
		this.portfolioDetails = portfolioDetails;
	}

	public Skills(long id, String name, PortFolioDetails portfolioDetails) {
		super();
		this.id = id;
		this.name = name;
		this.portfolioDetails = portfolioDetails;
	}

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + ", portfolioDetails=" + portfolioDetails + "]";
	}
	
	
}
