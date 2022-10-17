package com.habfinans.habfinans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.engine.AttributeName;

import com.habfinans.habfinans.entities.Employee;
import com.habfinans.habfinans.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/* @RestController */
@Controller
public class EmployeesController {
    @Autowired
    private EmployeeService service;

    @GetMapping({"/"})
    public String index(){
        return "index";
    }

    @GetMapping({"/enter"})
    public String paginaAdministrador(Model model){
        model.addAttribute("employees", service.getEmployees());
        return "pagina_admin";
    }

    @GetMapping({"/new"})
    public String formularioNuevoEmpleado(Model model){
        model.addAttribute("employee", new Employee());
        return "crear_empleado";
    }

    @PostMapping({"/enter"})
    public RedirectView crearEmpleado(@ModelAttribute Employee employee, Model model){
        model.addAttribute(employee);
        this.service.createEmployee(employee);
        return new RedirectView("/enter");
    }



/*     @RequestMapping(value = "/employees")
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

    } */

}
