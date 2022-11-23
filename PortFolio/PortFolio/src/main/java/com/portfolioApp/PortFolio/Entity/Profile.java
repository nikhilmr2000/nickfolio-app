package com.portfolioApp.PortFolio.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Register")
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column(name="Name")
	public String name;
	
	@Column(name="Email")
	public String email;
	
	@Column(name="PhoneNumber")
	public String phoneNumber;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name="password")
	public String password;
	
	@ManyToOne
	@JoinColumn(name="authority_id")
	public Authority authority;
	
	@JsonIgnore
	@OneToOne(mappedBy = "profile")
    private PortFolioDetails portFolios;
	
	public Profile() {
		super();
	}
	
	public Profile(String name,String email,String phoneNumber,String password) {
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.password=password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}
	
	
}
