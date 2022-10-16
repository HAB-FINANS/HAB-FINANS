package com.habfinans.habfinans.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habfinans.habfinans.entities.Employee;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeesController {
    @RequestMapping(value = "/employees45")
    public Employee getEmployees(){
        Employee employee = new Employee();
        employee.setName("Andres Felipe");
        employee.setEmail("afmendoza@gmail.com");
        employee.setRole("Devolper");
        employee.setEnterprise("AFMT SAS");
        employee.setProfile("andresfelipe");
        employee.setPassword("123456");
        return employee;
    }

    @RequestMapping(value = "/employees")
    public List<Employee> getEmployees(@PathVariable Long id){
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Andres Felipe");
        employee.setEmail("afmendoza@gmail.com");
        employee.setRole("Devolper");
        employee.setEnterprise("AFMT SAS");
        employee.setProfile("andresfelipe");
        employee.setPassword("123456");

        employee.add(employee)

        #return employee;
    }

}
