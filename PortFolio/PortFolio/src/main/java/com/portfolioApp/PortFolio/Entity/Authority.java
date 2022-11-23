package com.portfolioApp.PortFolio.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Authority")
public class Authority {
	
	@Id
	public Long id;
	
	@Column(name="name")
	public String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="authority",fetch = FetchType.EAGER)
	public List<Profile> profiles=new ArrayList<>();
	
	public Authority() {
		super();
	}
	
	public Authority(long id,String name) {
		this.id=id;
		this.name=name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
