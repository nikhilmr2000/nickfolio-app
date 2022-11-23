package com.portfolioApp.PortFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioApp.PortFolio.Entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long>{
	
	
}
