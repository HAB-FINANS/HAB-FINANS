package com.habfinans.habfinans.Models;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Transactions")
public class Transaction {
    //Attributes
    @Id
    private Long idTransaction;
    @Column
    private String conceptTransaction;
    @Column
    private float amountTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private Employee employeeTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "idEnterprise")
    private Enterprise enterpriseTransaction;
    @Column
    private Date createdAtTransaction;
    @Column
    private Date updatedAtTransaction;

    //Constructor
    public Transaction(Long idTransaction, String conceptTransaction, float amountTransaction,
            Date createdAtTransaction, Date updatedAtTransaction) {
        this.idTransaction = idTransaction;
        this.conceptTransaction = conceptTransaction;
        this.amountTransaction = amountTransaction;
        this.createdAtTransaction = createdAtTransaction;
        this.updatedAtTransaction = updatedAtTransaction;
    } 

    //Constructor Empty
    public Transaction(){

    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getConceptTransaction() {
        return conceptTransaction;
    }

    public void setConceptTransaction(String conceptTransaction) {
        this.conceptTransaction = conceptTransaction;
    }

    public float getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(float amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public Employee getEmployeeTransaction() {
        return employeeTransaction;
    }

    public void setEmployeeTransaction(Employee employeeTransaction) {
        this.employeeTransaction = employeeTransaction;
    }

    public Enterprise getEnterpriseTransaction() {
        return enterpriseTransaction;
    }

    public void setEnterpriseTransaction(Enterprise enterpriseTransaction) {
        this.enterpriseTransaction = enterpriseTransaction;
    }

    public Date getCreatedAtTransaction() {
        return createdAtTransaction;
    }

    public void setCreatedAtTransaction(Date createdAtTransaction) {
        this.createdAtTransaction = createdAtTransaction;
    }

    public Date getUpdatedAtTransaction() {
        return updatedAtTransaction;
    }

    public void setUpdatedAtTransaction(Date updatedAtTransaction) {
        this.updatedAtTransaction = updatedAtTransaction;
    }

    //Getters and Setters
    
    
}
