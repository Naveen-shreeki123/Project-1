package com.example.demo.employee.Service;


import com.example.demo.employee.Model.Department;
import com.example.demo.employee.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository repository;

    public void save(Department department){
        repository.save(department);
    }

    public List<Department> findAll(){
        return repository.findAll();
    }

    public Optional<Department> findDepartmentById(long DepartmentId){
        return repository.findById(DepartmentId);
    }

    public String deleteDepartment(long DepartmentId){
        repository.deleteById(DepartmentId);
        return "Department Removed";
    }
}