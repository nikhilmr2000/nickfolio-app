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
@Table(name="achievements")
public class Acheievements {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="performance")
	private String performance;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="portfolioList_id")
	public PortFolioDetails portfolioList;	
	
	public Acheievements() {
		super();
	}
	
	public Acheievements(String name,String performance) {
		this.name=name;
		this.performance=performance;
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

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public PortFolioDetails getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(PortFolioDetails portfolioList) {
		this.portfolioList = portfolioList;
	}

	@Override
	public String toString() {
		return "Acheievements [id=" + id + ", name=" + name + ", performance=" + performance + ", portfolioList="
				+ portfolioList + "]";
	}
	
	
}
