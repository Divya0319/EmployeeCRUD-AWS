package com.example.employeeCrudAws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
	
	@GetMapping("/welcome")
	public String getDefaultResponse() {
		return "Hi, you have successfully configured H2 database and Spring Booot data JPA in this project";
	}

}
