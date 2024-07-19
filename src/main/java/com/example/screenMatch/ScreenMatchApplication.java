package com.example.screenMatch;

import com.example.screenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.screenMatch.principal.Principal;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);

	}

	@Autowired
	SerieRepository repository;
	
	@Override
	public void run(String...args) throws Exception{
		
		Principal principal = new Principal(repository);
		
		principal.exibeMenu();
	
		
	}

}
