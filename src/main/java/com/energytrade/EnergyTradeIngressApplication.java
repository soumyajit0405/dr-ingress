package com.energytrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 * 
 * @author Soumyajit
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class EnergyTradeIngressApplication {

	public static void main(String[] args) {
		System.out.println("Starting Energy Trade DR Ingress Main");
		//System.setProperty("server.servlet.context-path");
		SpringApplication.run(EnergyTradeIngressApplication.class, args);
		//, "/inmo"
		
	}
}
