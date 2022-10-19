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

import com.habfinans.habfinans.entities.Enterprise;
import com.habfinans.habfinans.service.EnterpriseService;

@Controller
public class EnterpriseController {
    @Autowired
    private EnterpriseService service;

    @GetMapping({"/enterprise_admin"})
    public String enterprise_admin(){
        return "gestion_empresas";
    }
}
