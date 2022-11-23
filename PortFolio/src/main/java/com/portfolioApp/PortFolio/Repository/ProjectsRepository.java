package com.portfolioApp.PortFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolioApp.PortFolio.Entity.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long>{

}
