package com.example.demo.employee.Service;

import com.example.demo.employee.Model.Employee;
import com.example.demo.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


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
        Boolean exists = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(exists){
            throw new IllegalStateException(
                    "Email " + employee.getEmail() + " taken");
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
