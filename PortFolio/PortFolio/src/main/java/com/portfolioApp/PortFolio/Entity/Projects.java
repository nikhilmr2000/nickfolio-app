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
@Table(name="projects")
public class Projects {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="about")
	private String about;
	
	@Column(name="stacks")
	private String stack;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="portfolios_id")
	public PortFolioDetails portfolios;
	
	public Projects() {
		super();
	}
	
	public Projects(String name,String about,String stack) {
		this.name=name;
		this.about=about;
		this.stack=stack;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public PortFolioDetails getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(PortFolioDetails portfolios) {
		this.portfolios = portfolios;
	}

	@Override
	public String toString() {
		return "Projects [id=" + id + ", name=" + name + ", about=" + about + ", stack=" + stack + ", portfolios="
				+ portfolios + "]";
	}
	
	
}
