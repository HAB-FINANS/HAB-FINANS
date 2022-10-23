package com.habfinans.habfinans.service;

import java.util.List;

import com.habfinans.habfinans.Models.Transaction;

public interface ServiceInterfaceTransactions {
        //Metodo para ver lista de Transaction
        public List<Transaction> getTransaction();

        //Metodo que trae un Transaction
        public Transaction getOnlyOneTransaction(Long idTransaction) throws Exception;
    
        //Metodo que crea una Transaction
        public String getCreateTransaction(Transaction TransactionIn);
    
        //Metodo que permite actualizar una Transaction
        public Transaction getUpdateTransaction(Transaction TransactionIn) throws Exception;
    
        //Metodo que elimina una Transaction
        public String getDeleteTransaction(Long idTransaction) throws Exception;
    
}
