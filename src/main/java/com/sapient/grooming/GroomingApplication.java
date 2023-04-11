package com.sapient.grooming;

import com.sapient.grooming.Model.FindJob;
import com.sapient.grooming.Model.GenerateUsername;
import com.sapient.grooming.Model.Role;
import com.sapient.grooming.Model.Tech;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class GroomingApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GroomingApplication.class, args);
//		GenerateUsername generateUsername = new GenerateUsername();
//		generateUsername.takeInput();
//		System.out.print("Your Username is : " + generateUsername.generateUsername());
		FindJob findJob = new FindJob();
		findJob.takeInput();
		System.out.println("Expected Salary : "+ findJob.expectedSalary());
	}

}
