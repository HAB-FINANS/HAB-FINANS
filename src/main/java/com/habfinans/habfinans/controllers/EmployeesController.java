package com.habfinans.habfinans.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habfinans.habfinans.entities.Employee;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeesController {


    @RequestMapping(value = "/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(10L);
        employee.setName("Andres Felipe");
        employee.setEmail("afmendoza@gmail.com");
        employee.setRole("Devolper");
        employee.setEnterprise("AFMT SAS");
        employee.setProfile("andresfelipe");
        employee.setPassword("123456");

        employees.add(employee);
        return employees;

    }

}
