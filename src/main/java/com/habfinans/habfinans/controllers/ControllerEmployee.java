package com.habfinans.habfinans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habfinans.habfinans.Models.Employee;
import com.habfinans.habfinans.Models.ObjectAnswer;
import com.habfinans.habfinans.service.ServiceInterfaceEmployee;

@RestController
public class ControllerEmployee {
    
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEmployee
    @Autowired
    private ServiceInterfaceEmployee serviceInterfaceEmployee;

    //Creamos los mapping
    @GetMapping("/ListEmployee")
    public ResponseEntity <List<Employee>> getEmployee(){
        return new ResponseEntity<>(serviceInterfaceEmployee.getEmployee(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola empresa
    @GetMapping("/OneEmployee/{idEmployee}")
    public ResponseEntity<Object> getEmployeePath(@PathVariable Long idEmployee){
        try{
            Employee EmployeeX = serviceInterfaceEmployee.getOnlyOneEmployee(idEmployee);
            return new ResponseEntity<>(EmployeeX,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una empresa
    @PostMapping("/CreateEmployee")
    public ResponseEntity<String> PostCreateEmployee(@RequestBody Employee EmployeeX){
        try {
            String message = serviceInterfaceEmployee.getCreateEmployee(EmployeeX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Employee
    @PutMapping("/updateEmployee")
    public ResponseEntity<ObjectAnswer> putUpdateEmployee(@RequestBody Employee EmployeeX){
        try {
            Employee EmployeeBD = serviceInterfaceEmployee.getUpdateEmployee(EmployeeX);
            return new ResponseEntity<>(new ObjectAnswer("Actualización de Employee exitosa", EmployeeBD), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
    }

    //Mapping para eliminar una Employee
    @DeleteMapping("/DeleteEmployee/{idEmployee}")
    public ResponseEntity<String> getDeleteEmployee(@PathVariable Long idEmployee){
        try {
            String message = serviceInterfaceEmployee.getDeleteEmployee(idEmployee);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
