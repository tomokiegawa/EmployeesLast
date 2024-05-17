package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
//chatgpt.com/c/21dc1dc5-eb49-4090-84fe-a2f8a601fb54g.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.repository")
public class EmployeesLastApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesLastApplication.class, args);
	}

}
