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

import com.habfinans.habfinans.Models.Transaction;
//import com.habfinans.habfinans.Models.ObjectAnswer;
import com.habfinans.habfinans.service.ServiceInterfaceTransactions;

/* @RestController */
@Controller
public class ControllerTransaction {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEtransaction
    @Autowired
    private ServiceInterfaceTransactions serviceInterfaceTransaction;

    //Lista de etransaction
    @GetMapping({"/transaction_admin"})
    public String listarTransaction(Model model){
        model.addAttribute("transaction", serviceInterfaceTransaction.getTransaction());
        return "admin_transaction";
    }



    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_transaction"})
    public String fromNewTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        return "create_transaction";
    }



    //Devolverse al la página después de crear la etransaction
    @PostMapping({"/transaction_admin"})
    public RedirectView crearTransaction(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Transaction transaction, Model model){
        model.addAttribute(transaction);
        this.serviceInterfaceTransaction.getCreateTransaction(transaction);
        return new RedirectView("/transaction_admin");
    }

    //Eliminar un registro
    @DeleteMapping("/transaction_admin/delete/{idTransaction}")
    public String eliminarTransaction(@PathVariable Long idTransaction) throws Exception{
        serviceInterfaceTransaction.getDeleteTransaction(idTransaction);
        return "redirect:/transaction_admin";
    }

    @GetMapping("/transaction_admin/edit/{idTransaction}")
    public String formularioEditar(@PathVariable long idTransaction, Model model) throws Exception {
        Transaction transaction = serviceInterfaceTransaction.getOnlyOneTransaction(idTransaction);
        model.addAttribute("transaction", transaction);

        return "update_transaction";
    }

    @PostMapping("/transaction_admin/update/{idTransaction}")
    public String actualizarTransaction(@PathVariable("idTransaction") Long idTransaction, Transaction transaction) throws Exception{
        serviceInterfaceTransaction.getUpdateTransaction(transaction);

        return "redirect:/transaction_admin";
    }


   

/*     @GetMapping("/transaction_admin/movements/{idEmployee}")
    public String formularioTransacciones(@PathVariable long idEmployee, Model model) throws Exception {
        Employee employee = serviceInterfaceTransaction.getOnlyOneEmployee(idEmployee);
        model.addAttribute("employee", employee);

        return "movements_transaction";
    }
 */
/* 
    //Creamos los mapping
    @GetMapping("/ListEtransaction")
    public ResponseEntity <List<Etransaction>> getEtransaction(){
        return new ResponseEntity<>(serviceInterfaceEtransaction.getEtransaction(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola empresa
    @GetMapping("/OneEtransaction/{idEtransaction}")
    public ResponseEntity<Object> getEtransactionPath(@PathVariable Long idEtransaction){
        try{
            Etransaction EtransactionX = serviceInterfaceEtransaction.getOnlyOneEtransaction(idEtransaction);
            return new ResponseEntity<>(EtransactionX,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una empresa
    @PostMapping("/CreateEtransaction")
    public ResponseEntity<String> PostCreateEtransaction(@RequestBody Etransaction EtransactionX){
        try {
            String message = serviceInterfaceEtransaction.getCreateEtransaction(EtransactionX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Etransaction
    @PutMapping("/updateEtransaction")
    public ResponseEntity<ObjectAnswer> putUpdateEtransaction(@RequestBody Etransaction EtransactionX){
        try {
            Etransaction EtransactionBD = serviceInterfaceEtransaction.getUpdateEtransaction(EtransactionX);
            return new ResponseEntity<>(new ObjectAnswer("Actualización de Etransaction exitosa", EtransactionBD), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
    }

    //Mapping para eliminar una etransaction
    @DeleteMapping("/DeleteEtransaction/{idEtransaction}")
    public ResponseEntity<String> getDeleteEtransaction(@PathVariable Long idEtransaction){
        try {
            String message = serviceInterfaceEtransaction.getDeleteEtransaction(idEtransaction);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

    


/* --------------------------------------------------------------------- */






/*     //Lista de empresas
    @GetMapping({"/etransaction_admin"})
    public String listarEmpresa(Model model){
        model.addAttribute("etransaction", service.getEtransaction());
        return "gestion_empresas";
    } */

    //Traer una sola empresa
    /* @GetMapping("/OneEtransaction/{idEtransaction}") */

/* 
    //Eliminar una etransaction
    @DeleteMapping({"/delete/{id}"})
    public RedirectView eliminarEtransaction(@PathVariable Long idEtransaction) throws Exception{
        service.getDeleteEtransaction(idEtransaction);
        return new RedirectView("/etransaction_admin");
    } 


    @PostMapping({"/etransaction_admin"})
    public RedirectView crearEmpresa(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-DD") Etransaction etransaction, Model model){
        model.addAttribute(etransaction);
        this.service.getCreateEtransaction(etransaction);
        return new RedirectView("/etransaction_admin");
    }

    //Dirigirse a crear una nueva empresa 
    @GetMapping({"/new_etransaction"})
    public String fromNewEtransaction(Model model){
        model.addAttribute("etransaction", new Etransaction());
        return "crear_empresa";
    }
 */

    
}
