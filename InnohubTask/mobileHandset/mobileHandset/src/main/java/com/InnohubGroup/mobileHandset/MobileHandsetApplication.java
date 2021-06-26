package com.InnohubGroup.mobileHandset;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.InnohubGroup.mobileHandset.models.*;
import com.InnohubGroup.mobileHandset.services.MobileCatalougeService;
@SpringBootApplication
@ComponentScan(basePackages = {"com.axiomtelecom"})
@EntityScan("com.axiomtelecom.mobileHandset.models")
@EnableJpaRepositories("com.axiomtelecom.mobileHandset.daos")
public class MobileHandsetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileHandsetApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(@Autowired MobileCatalougeService mobileCatalougeService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MobileHandset>> typeReference = new TypeReference<List<MobileHandset>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/mobileDatabase.json");
			try {
				List<MobileHandset> Mobiledata = mapper.readValue(inputStream,typeReference);
				mobileCatalougeService.save(Mobiledata);
				System.out.println("Data Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Data: " + e.getMessage());
			}
		};
	}
}
