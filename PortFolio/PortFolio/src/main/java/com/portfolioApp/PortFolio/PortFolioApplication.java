package com.portfolioApp.PortFolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portfolioApp.PortFolio.Service.RegisterService;

@SpringBootApplication
public class PortFolioApplication {
	
	@Autowired
	public RegisterService service;

	public static void main(String[] args) {
		SpringApplication.run(PortFolioApplication.class, args);
	}
	
	@Bean
	public void callService() {
		service.saveAuthority();
	}

}
