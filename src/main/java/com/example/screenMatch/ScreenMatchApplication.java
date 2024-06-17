package com.example.screenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.screenMatch.principal.Principal;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
		
	}
	
	@Override
	public void run(String...args) throws Exception{
		
		Principal principal = new Principal();
		
		principal.exibeMenu();
	
		
	}

}
