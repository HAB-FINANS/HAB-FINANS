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

import com.habfinans.habfinans.Models.Transaction;
import com.habfinans.habfinans.Models.ObjectAnswer;
import com.habfinans.habfinans.service.ServiceInterfaceTransactions;

@RestController
public class ControllerTransaction {
      //Hacemos la inyeccion del objeto de tipo ServiceInterfaceTransaction
      @Autowired
      private ServiceInterfaceTransactions serviceInterfaceTransaction;


      
  
      //Creamos los mapping
      @GetMapping("/ListTransaction")
      public ResponseEntity <List<Transaction>> getTransaction(){
          return new ResponseEntity<>(serviceInterfaceTransaction.getTransaction(), HttpStatus.ACCEPTED);
      }
  
      //Mapping para traer una sola empresa
      @GetMapping("/OneTransaction/{idTransaction}")
      public ResponseEntity<Object> getTransactionPath(@PathVariable Long idTransaction){
          try{
              Transaction TransactionX = serviceInterfaceTransaction.getOnlyOneTransaction(idTransaction);
              return new ResponseEntity<>(TransactionX,HttpStatus.OK);
          }
          catch(Exception e){
              return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
  
      //Mapping para crear una empresa
      @PostMapping("/CreateTransaction")
      public ResponseEntity<String> PostCreateTransaction(@RequestBody Transaction TransactionX){
          try {
              String message = serviceInterfaceTransaction.getCreateTransaction(TransactionX);
              return new ResponseEntity<>(message, HttpStatus.OK);
          }
          catch (Exception e){
              return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
  
      //Mapping para actualizar una Transaction
      @PutMapping("/updateTransaction")
      public ResponseEntity<ObjectAnswer> putUpdateTransaction(@RequestBody Transaction TransactionX){
          try {
              Transaction TransactionBD = serviceInterfaceTransaction.getUpdateTransaction(TransactionX);
              return new ResponseEntity<>(new ObjectAnswer("Actualización de Transaction exitosa", TransactionBD), HttpStatus.OK);
          }
          catch (Exception e){
              return new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
          }
   
      }
  
      //Mapping para eliminar una Transaction
      @DeleteMapping("/DeleteTransaction/{idTransaction}")
      public ResponseEntity<String> getDeleteTransaction(@PathVariable Long idTransaction){
          try {
              String message = serviceInterfaceTransaction.getDeleteTransaction(idTransaction);
              return new ResponseEntity<>(message, HttpStatus.OK);
          }
          catch (Exception e){
              return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
  
}
