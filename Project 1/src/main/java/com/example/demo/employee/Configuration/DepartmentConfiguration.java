package com.example.demo.employee.Configuration;


import com.example.demo.employee.Model.Department;
import com.example.demo.employee.Repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DepartmentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository repository) {
        return args -> {
            Department dp1 = new Department(1,"Payments Bank","Abhinav Gupta");
            Department dp2 = new Department(2,"FastTag","Shyam Sundar");
            Department dp3 = new Department(3,"EDC","Hussian");
            Department dp4 = new Department(4,"Insurance","MD Siddiq");

            repository.saveAll(List.of(dp1,dp2,dp3,dp4));
        };
    }
}
