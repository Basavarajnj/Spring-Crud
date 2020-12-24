package com.mab.crud.example.service;

import com.mab.crud.example.entity.Employee;
 
import com.mab.crud.example.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository rep;

    public String saveEmployee(Employee Employee) {
        rep.save(Employee);
        return "Inserted";
    }

    public List<Employee> saveEmployees(List<Employee> Employees) {
        return rep.saveAll(Employees);
    }

    public List<Employee> getEmployees() {
        return rep.findAll();
    }

    public Employee getEmployeeById(int id) {
        return rep.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return rep.findByName(name);
    }

    public String deleteEmployee(int id) {
        rep.deleteById(id);
        return "Employee deleted" +" "+
        		id;
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = rep.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setJob(employee.getJob());
        
        return rep.save(existingEmployee);
    }


}
