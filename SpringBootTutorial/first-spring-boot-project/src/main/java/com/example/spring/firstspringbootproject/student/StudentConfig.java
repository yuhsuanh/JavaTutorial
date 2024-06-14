package com.example.spring.firstspringbootproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student sean = new Student("Sean", "seanhuang@email.com", LocalDate.of(1992, 9, 30)/*, 28*/);
            Student winnie = new Student("Winnie", "winnielai@email.com", LocalDate.of(1993, 3, 31)/*, 27*/);

            studentRepository.saveAll(List.of(sean, winnie));

        };
    }

}
