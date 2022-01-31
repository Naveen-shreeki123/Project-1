package com.example.demo.employee.Controller;

import com.example.demo.employee.Model.Department;
import com.example.demo.employee.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/department")
@EnableCaching
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping
    public void save(@RequestBody Department department){
        service.save(department);
    }

    @GetMapping
    @Cacheable(value = "department")
    public List<Department> getAllProducts(){
        return service.findAll();
    }

    @GetMapping("/{DepartmentId}")
    @Cacheable(key = "#DepartmentId", value = "department")
    public Optional<Department> findProductById(@PathVariable int DepartmentId){
        return service.findDepartmentById(DepartmentId);
    }

    @DeleteMapping("/{DepartmentId}")
    @CacheEvict(key = "#DepartmentId", value = "department")
    public  String remove(@PathVariable int DepartmentId){
        return service.deleteDepartment(DepartmentId);
    }
}

