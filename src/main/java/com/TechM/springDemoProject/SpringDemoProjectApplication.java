package com.TechM.springDemoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoProjectApplication.class, args);
	}

}
