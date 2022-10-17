package com.habfinans.habfinans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.entities.Employee;
import com.habfinans.habfinans.repository.EmployeeRepository;
/* import com.habfinans.habfinans.entities.Employee;  */
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployees(){
        return repository.findAll();
    } 

    public boolean createEmployee(Employee employee){
        try{

        repository.save(employee);
            return true;
        }
catch (Exception e){
    return false;
}
    } 
}
