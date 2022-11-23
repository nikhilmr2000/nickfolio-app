package com.portfolioApp.PortFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioApp.PortFolio.Entity.PortFolioDetails;

@Repository
public interface PortFolioDetailsRepository extends JpaRepository<PortFolioDetails,Long>{

}
