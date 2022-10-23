package com.habfinans.habfinans.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.Models.Transaction;
import com.habfinans.habfinans.repository.RepsoitoryTransaction;

@Service
public class ServiceTransaction  implements ServiceInterfaceTransactions{
    
    //Attribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Transaction
    @Autowired
    RepsoitoryTransaction repositoryTransaction;
    

    @Override
    public String getCreateTransaction(Transaction TransactionIn) {
        //Preguntar si ya existe una Transaction con ese ID
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(TransactionIn.getIdTransaction());
        if(!TransactionBD.isPresent()){
            repositoryTransaction.save(TransactionIn);
            return ("Transaction creada con exito");
        }
        return ("Ese Id ya está asignado a una Transaction existente");
    }

    @Override
    public String getDeleteTransaction(Long idTransaction) throws Exception {
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(idTransaction);
        if(TransactionBD.isPresent()){
            repositoryTransaction.deleteById(idTransaction);
            return ("Transaction eliminada con exito");
        }
        throw new Exception("Transaction no encontrada");
    }

    @Override
    public List<Transaction> getTransaction() {
        return repositoryTransaction.findAll();
    }

    @Override
    public Transaction getOnlyOneTransaction(Long idTransaction) throws Exception {
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(idTransaction);
        if(TransactionBD.isPresent()){
            return TransactionBD.get();
        }
        throw new Exception("IdTransaction no asignado a ninguna en la base de datos");
    }

    @Override
    public Transaction getUpdateTransaction(Transaction TransactionIn) throws Exception {
        //Llamamos a la Transaction a actualizar en la BD
        Transaction TransactionBD = getOnlyOneTransaction(TransactionIn.getIdTransaction());

        //Actualizamos los atributos
        if(TransactionIn.getConceptTransaction()!=null && !TransactionIn.getConceptTransaction().equals("")){
            TransactionBD.setConceptTransaction(TransactionIn.getConceptTransaction());
        }

        String amountCast = String.valueOf(TransactionIn.getAmountTransaction());
        if(amountCast!=null && !amountCast.equals("")){
            TransactionBD.setAmountTransaction(TransactionIn.getAmountTransaction());
        }

        TransactionBD.setUpdatedAtTransaction(Today);
        
        return repositoryTransaction.save(TransactionBD);
    }
}
