package com.mab.crud.example.controller;

import com.mab.crud.example.entity.Employee;
import com.mab.crud.example.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeService emp;
    
   
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee Employee) {
         emp.saveEmployee(Employee);
        		return "Inserted";
    }

    
    
    
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> Employees) {
        return emp.saveEmployees(Employees);
        
    }

    
    @GetMapping("/Employees")
    public List<Employee> findAllEmployees() {
        return emp.getEmployees();
    }

    @GetMapping("/EmployeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return emp.getEmployeeById(id);
    }

    
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee Employee) {
        return emp.updateEmployee(Employee);
    }

    
    
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return emp.deleteEmployee(id);
    }
}
