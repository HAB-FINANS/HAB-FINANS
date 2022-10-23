package com.habfinans.habfinans.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.Models.Employee;
import com.habfinans.habfinans.repository.RepositoryEmployee;

@Service

public class ServiceEmployee implements ServiceInterfaceEmployee{
    
    //Attribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Employee
    @Autowired
    RepositoryEmployee repositoryEmployee;
    

    @Override
    public String getCreateEmployee(Employee EmployeeIn) {
        //Preguntar si ya existe una Employee con ese ID
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(EmployeeIn.getIdEmployee());
        if(!EmployeeBD.isPresent()){
            repositoryEmployee.save(EmployeeIn);
            return ("Employee creada con exito");
        }
        return ("Ese Id ya está asignado a una Employee existente");
    }

    @Override
    public String getDeleteEmployee(Long idEmployee) throws Exception {
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            repositoryEmployee.deleteById(idEmployee);
            return ("Employee eliminada con exito");
        }
        throw new Exception("Employee no encontrada");
    }

    @Override
    public List<Employee> getEmployee() {
        return repositoryEmployee.findAll();
    }

    @Override
    public Employee getOnlyOneEmployee(Long idEmployee) throws Exception {
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            return EmployeeBD.get();
        }
        throw new Exception("IdEmployee no asignado a ninguna en la base de datos");
    }

    @Override
    public Employee getUpdateEmployee(Employee EmployeeIn) throws Exception {
        //Llamamos a la Employee a actualizar en la BD
        Employee EmployeeBD = getOnlyOneEmployee(EmployeeIn.getIdEmployee());

        //Actualizamos los atributos
        if(EmployeeIn.getNameEmployee()!=null && !EmployeeIn.getNameEmployee().equals("")){
            EmployeeBD.setNameEmployee(EmployeeIn.getNameEmployee());
        }

        if(EmployeeIn.getEmailEmployee()!=null && !EmployeeIn.getEmailEmployee().equals("")){
            EmployeeBD.setEmailEmployee(EmployeeIn.getEmailEmployee());
        }


        if(EmployeeIn.getRolesEmployee()!=null && !EmployeeIn.getRolesEmployee().equals("")){
            EmployeeBD.setRolesEmployee(EmployeeIn.getRolesEmployee());
        }


        if(EmployeeIn.getPhoneEmployee()!=null && !EmployeeIn.getPhoneEmployee().equals("")){
            EmployeeBD.setPhoneEmployee(EmployeeIn.getPhoneEmployee());
        }

        EmployeeBD.setUpdatedAtEmployee(Today);
        
        return repositoryEmployee.save(EmployeeBD);
    }
}
