package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee)
    {
        // Logging an Exception if the data is already present.
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Employee data already exist !!!");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        // Logging an Exception if user tries to delete a data which is not present.
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new IllegalStateException("Employee with employee ID "+ employeeId +" not found !!!");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String name, String email) {
        // Logging an Exception if user tries to delete a data which is not present.
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException("Employee with employee ID "+ employeeId +" not found !!!"));

        if(name != null && name.length() > 0 && !Objects.equals(employee.getName(),name)){
            employee.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(employee.getEmail(),email)){
            employee.setEmail(email);
        }
    }
}
