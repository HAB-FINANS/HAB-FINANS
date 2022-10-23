package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habfinans.habfinans.Models.Transaction;

public interface RepsoitoryTransaction extends JpaRepository<Transaction, Long>{
    
}
