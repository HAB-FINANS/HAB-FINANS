package com.habfinans.habfinans.service;

import java.util.List;

import com.habfinans.habfinans.Models.Employee;

public interface ServiceInterfaceEmployee {
        //Metodo para ver lista de Employee
        public List<Employee> getEmployee();

        //Metodo que trae un Employee
        public Employee getOnlyOneEmployee(Long idEmployee) throws Exception;
    
        //Metodo que crea una Employee
        public String getCreateEmployee(Employee EmployeeIn);
    
        //Metodo que permite actualizar una Employee
        public Employee getUpdateEmployee(Employee EmployeeIn) throws Exception;
    
        //Metodo que elimina una Employee
        public String getDeleteEmployee(Long idEmployee) throws Exception;
}
