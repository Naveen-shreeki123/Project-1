package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Naveen = new Employee("Naveen","naveen@gmail.com","987654321",22,25000,"Dev Program");
            Employee Shyam = new Employee("Shyam","shyam@gmail.com","887643321",21,27000,"Q/A");

            repository.saveAll(List.of(Naveen,Shyam));
        };

    }
}
