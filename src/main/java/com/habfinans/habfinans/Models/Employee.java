package com.habfinans.habfinans.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="Employees")
public class Employee {
    //Attributes
    @Id
    private Long idEmployee;
    @Column
    private String nameEmployee;
    @Column
    private String phoneEmployee;
    @Column
    private String emailEmployee;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ROLES.class,fetch = FetchType.EAGER)
    private List<ROLES> rolesEmployee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Enterprise enterpriseEmployee;
    @OneToMany
    private List<Transaction> transaction;
    @Column
    private Date updatedAtEmployee;
    @Column
    private Date createdAtEmployee;

    //Constructor
    public Employee(Long idEmployee, String nameEmployee, String phoneEmployee, String emailEmployee,
            Date updatedAtEmployee, Date createdAtEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.updatedAtEmployee = updatedAtEmployee;
        this.createdAtEmployee = createdAtEmployee;
    }

    //Constructor Empty
    public Employee(){

    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmpleado) {
        this.idEmployee = idEmpleado;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public List<ROLES> getRolesEmployee() {
        return rolesEmployee;
    }

    public void setRolesEmployee(List<ROLES> rolesEmployee) {
        this.rolesEmployee = rolesEmployee;
    }

    public Enterprise getEnterpriseEmployee() {
        return enterpriseEmployee;
    }

    public void setEnterpriseEmployee(Enterprise enterpriseEmployee) {
        this.enterpriseEmployee = enterpriseEmployee;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Date getUpdatedAtEmployee() {
        return updatedAtEmployee;
    }

    public void setUpdatedAtEmployee(Date updatedAtEmployee) {
        this.updatedAtEmployee = updatedAtEmployee;
    }

    public Date getCreatedAtEmployee() {
        return createdAtEmployee;
    }

    public void setCreatedAtEmployee(Date createdAtEmployee) {
        this.createdAtEmployee = createdAtEmployee;
    }

    // Setters and Getters
    
    
}
