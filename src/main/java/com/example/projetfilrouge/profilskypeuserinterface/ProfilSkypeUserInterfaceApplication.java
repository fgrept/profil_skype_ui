package com.example.projetfilrouge.profilskypeuserinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.projetfilrouge.profilskypeuserinterface")
public class ProfilSkypeUserInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilSkypeUserInterfaceApplication.class, args);
	}

}
