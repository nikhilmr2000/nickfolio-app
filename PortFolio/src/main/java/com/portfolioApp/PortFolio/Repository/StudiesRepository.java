package com.portfolioApp.PortFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioApp.PortFolio.Entity.Studies;

@Repository
public interface StudiesRepository extends JpaRepository<Studies,Long>{

}
