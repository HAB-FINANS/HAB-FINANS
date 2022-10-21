package com.habfinans.habfinans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.habfinans.habfinans.entities.Profile;
import com.habfinans.habfinans.service.ProfileService;

/* @RestController */
@Controller
public class ProfileController {
    @Autowired
    private ProfileService service;



        @PostMapping({"/employee_admin"})
        public RedirectView crearEmpleado(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Profile profile, Model model){
            model.addAttribute(profile);
            this.service.createProfile(profile);
            return new RedirectView("/employee_admin");
    }

    @GetMapping({"/new_profile"})
    public String formularioNuevoEmpleado(Model model){
        model.addAttribute("profile", new Profile());
        return "crear_empleado";
    }

    @GetMapping({"/employee_admin"})
    public String listarEmpleados(Model model){
        model.addAttribute("profile", service.getProfile());
        return "gestion_empleados";
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
