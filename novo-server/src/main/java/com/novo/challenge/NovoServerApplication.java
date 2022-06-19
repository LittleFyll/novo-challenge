package com.novo.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NovoServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(NovoServerApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner run(PatientController controller) throws Exception {
		return (String[] args) -> {
			PatientDto patientDto = new PatientDto("Bob", "Marley", LocalDate.now(),"MALE", "bob@domain.com");
			PatientDto patientDto2 = new PatientDto(null, "Marley", LocalDate.now(),"MALE", "bob@domain.com");
			controller.createPatient(patientDto);
			controller.createPatient(patientDto2);
			controller.findAll().forEach(System.out::println);
		};
	}*/
}
