package com.habfinans.habfinans.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.habfinans.habfinans.Models.Employee;
//import com.habfinans.habfinans.Models.ROLES;
//import com.habfinans.habfinans.Models.ObjectAnswer;
import com.habfinans.habfinans.service.ServiceInterfaceEmployee;

/* @RestController */
@Controller
/* @RequestMapping("/") */
public class ControllerEmployee {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEmployee
    @Autowired
    private ServiceInterfaceEmployee serviceInterfaceEmployee;

    //Lista de employee
    @GetMapping({"/employee_admin"})
    public String listarEmpresa(Model model){
        model.addAttribute("employee", serviceInterfaceEmployee.getEmployee());
        return "admin_employee";
    }



    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_employee"})
    public String fromNewEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "create_employee";
    }



    //Devolverse al la página después de crear la employee
    @PostMapping({"/employee_admin"})
    public RedirectView crearEmployee(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Employee employee, Model model){
        model.addAttribute(employee);
        this.serviceInterfaceEmployee.getCreateEmployee(employee);
        return new RedirectView("/employee_admin");
    }

    //Eliminar un registro
    @DeleteMapping("/employee_admin/delete/{idEmployee}")
    public String eliminarEmployee(@PathVariable Long idEmployee) throws Exception{
        serviceInterfaceEmployee.getDeleteEmployee(idEmployee);
        return "redirect:/employee_admin";
    }

    @GetMapping("/employee_admin/edit/{idEmployee}")
    public String formularioEditar(@PathVariable long idEmployee, Model model) throws Exception {
        Employee employee = serviceInterfaceEmployee.getOnlyOneEmployee(idEmployee);
        model.addAttribute("employee", employee);

        return "update_employee";
    }

    @PostMapping("/employee_admin/update/{idEmployee}")
    public String actualizarEmployee(@PathVariable("idEmployee") Long idEmployee, Employee employee) throws Exception{
        serviceInterfaceEmployee.getUpdateEmployee(employee);

        return "redirect:/employee_admin";
    }

   
/* 
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

    //Mapping para eliminar una employee
    @DeleteMapping("/DeleteEmployee/{idEmployee}")
    public ResponseEntity<String> getDeleteEmployee(@PathVariable Long idEmployee){
        try {
            String message = serviceInterfaceEmployee.getDeleteEmployee(idEmployee);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

    


/* --------------------------------------------------------------------- */






/*     //Lista de empresas
    @GetMapping({"/employee_admin"})
    public String listarEmpresa(Model model){
        model.addAttribute("employee", service.getEmployee());
        return "gestion_empresas";
    } */

    //Traer una sola empresa
    /* @GetMapping("/OneEmployee/{idEmployee}") */

/* 
    //Eliminar una employee
    @DeleteMapping({"/delete/{id}"})
    public RedirectView eliminarEmployee(@PathVariable Long idEmployee) throws Exception{
        service.getDeleteEmployee(idEmployee);
        return new RedirectView("/employee_admin");
    } 


    @PostMapping({"/employee_admin"})
    public RedirectView crearEmpresa(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Employee employee, Model model){
        model.addAttribute(employee);
        this.service.getCreateEmployee(employee);
        return new RedirectView("/employee_admin");
    }

    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_employee"})
    public String fromNewEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "crear_empresa";
    }
 */

    
}
