package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Cst339Activity22Application 
{

	public static void main(String[] args) 
	{
		System.out.println(new BCryptPasswordEncoder().encode("Trainer1"));
		System.out.println(new BCryptPasswordEncoder().encode("password"));
		System.out.println(new BCryptPasswordEncoder().encode("newTrainer"));
		
		SpringApplication.run(Cst339Activity22Application.class, args);
	}

}
