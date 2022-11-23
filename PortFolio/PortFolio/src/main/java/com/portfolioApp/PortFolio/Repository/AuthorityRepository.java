package com.portfolioApp.PortFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioApp.PortFolio.Entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long>{
	
}
