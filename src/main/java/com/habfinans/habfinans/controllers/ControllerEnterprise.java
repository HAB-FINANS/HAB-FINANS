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
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.habfinans.habfinans.Models.Enterprise;
//import com.habfinans.habfinans.Models.ObjectAnswer;
import com.habfinans.habfinans.service.ServiceInterfaceEnterprise;

/* @RestController */
@Controller
public class ControllerEnterprise {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEnterprise
    @Autowired
    private ServiceInterfaceEnterprise serviceInterfaceEnterprise;

    //Lista de enterprise
    @GetMapping({"/enterprise_admin"})
    public String listarEmpresa(Model model){
        model.addAttribute("enterprise", serviceInterfaceEnterprise.getEnterprise());
        return "admin_enterprise";
    }



    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_enterprise"})
    public String fromNewEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "create_enterprise";
    }

    //Devolverse al la página después de crear la enterprise
    @PostMapping({"/enterprise_admin"})
    public RedirectView crearEnterprise(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.serviceInterfaceEnterprise.getCreateEnterprise(enterprise);
        return new RedirectView("/enterprise_admin");
    }

    //Eliminar un registro
    @DeleteMapping("/enterprise_admin/delete/{idEnterprise}")
    public String eliminarEnterprise(@PathVariable Long idEnterprise) throws Exception{
        serviceInterfaceEnterprise.getDeleteEnterprise(idEnterprise);
        return "redirect:/enterprise_admin";
    }


   
/* 
    //Creamos los mapping
    @GetMapping("/ListEnterprise")
    public ResponseEntity <List<Enterprise>> getEnterprise(){
        return new ResponseEntity<>(serviceInterfaceEnterprise.getEnterprise(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola empresa
    @GetMapping("/OneEnterprise/{idEnterprise}")
    public ResponseEntity<Object> getEnterprisePath(@PathVariable Long idEnterprise){
        try{
            Enterprise EnterpriseX = serviceInterfaceEnterprise.getOnlyOneEnterprise(idEnterprise);
            return new ResponseEntity<>(EnterpriseX,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una empresa
    @PostMapping("/CreateEnterprise")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Enterprise EnterpriseX){
        try {
            String message = serviceInterfaceEnterprise.getCreateEnterprise(EnterpriseX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Enterprise
    @PutMapping("/updateEnterprise")
    public ResponseEntity<ObjectAnswer> putUpdateEnterprise(@RequestBody Enterprise EnterpriseX){
        try {
            Enterprise EnterpriseBD = serviceInterfaceEnterprise.getUpdateEnterprise(EnterpriseX);
            return new ResponseEntity<>(new ObjectAnswer("Actualización de Enterprise exitosa", EnterpriseBD), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
    }

    //Mapping para eliminar una enterprise
    @DeleteMapping("/DeleteEnterprise/{idEnterprise}")
    public ResponseEntity<String> getDeleteEnterprise(@PathVariable Long idEnterprise){
        try {
            String message = serviceInterfaceEnterprise.getDeleteEnterprise(idEnterprise);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

    


/* --------------------------------------------------------------------- */






/*     //Lista de empresas
    @GetMapping({"/enterprise_admin"})
    public String listarEmpresa(Model model){
        model.addAttribute("enterprise", service.getEnterprise());
        return "gestion_empresas";
    } */

    //Traer una sola empresa
    /* @GetMapping("/OneEnterprise/{idEnterprise}") */

/* 
    //Eliminar una enterprise
    @DeleteMapping({"/delete/{id}"})
    public RedirectView eliminarEnterprise(@PathVariable Long idEnterprise) throws Exception{
        service.getDeleteEnterprise(idEnterprise);
        return new RedirectView("/enterprise_admin");
    } 


    @PostMapping({"/enterprise_admin"})
    public RedirectView crearEmpresa(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.service.getCreateEnterprise(enterprise);
        return new RedirectView("/enterprise_admin");
    }

    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_enterprise"})
    public String fromNewEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "crear_empresa";
    }
 */

    
}
