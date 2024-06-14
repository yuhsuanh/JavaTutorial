package com.example.spring.firstspringbootproject;

import com.example.spring.firstspringbootproject.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
//@RestController
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProjectApplication.class, args);
	}

//	@GetMapping
//	public List<Student> hello() {
//		return List.of( new Student(1L, "Sean", "seanhuang@mail.com", LocalDate.of(1992, 9, 30), 28));
//	}
}
