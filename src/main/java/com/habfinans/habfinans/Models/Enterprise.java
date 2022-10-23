package com.habfinans.habfinans.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="Enterprises")
public class Enterprise {
    //Attributes
    @Id
    private Long idEnterprise;
    @Column
    private String nameEnterprise;
    @Column
    private String NITEnterprise;
    @Column
    private String phoneEnterprise;
    @Column
    private String addressEnterprise;
    @OneToMany(mappedBy = "enterpriseTransaction")
    private List<Transaction> transaction;
    @OneToMany(mappedBy = "enterpriseEmployee")
    private List<Employee> employee;
    @Column
    private Date creatredAtEnterprise;
    @Column
    private Date updatedAtEnterprise;

    //Constructor
    public Enterprise(Long idEnterprise, String nameEnterprise, String nITEnterprise, String phoneEnterprise,
            String addressEnterprise, Date creatredAtEnterprise, Date updatedAtEnterprise) {
        this.idEnterprise = idEnterprise;
        this.nameEnterprise = nameEnterprise;
        NITEnterprise = nITEnterprise;
        this.phoneEnterprise = phoneEnterprise;
        this.addressEnterprise = addressEnterprise;
        this.creatredAtEnterprise = creatredAtEnterprise;
        this.updatedAtEnterprise = updatedAtEnterprise;
    }



    //Constructor Empty
    public Enterprise() {
    }

  
    //Getters and Setters
    

    public Long getIdEnterprise() {
        return idEnterprise;
    }



    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }



    public String getNameEnterprise() {
        return nameEnterprise;
    }



    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }



    public String getNITEnterprise() {
        return NITEnterprise;
    }



    public void setNITEnterprise(String nITEnterprise) {
        NITEnterprise = nITEnterprise;
    }



    public String getPhoneEnterprise() {
        return phoneEnterprise;
    }



    public void setPhoneEnterprise(String phoneEnterprise) {
        this.phoneEnterprise = phoneEnterprise;
    }



    public String getAddressEnterprise() {
        return addressEnterprise;
    }



    public void setAddressEnterprise(String addressEnterprise) {
        this.addressEnterprise = addressEnterprise;
    }



    public List<Transaction> getTransaction() {
        return transaction;
    }



    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }



    public List<Employee> getEmployee() {
        return employee;
    }



    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }



    public Date getCreatredAtEnterprise() {
        return creatredAtEnterprise;
    }



    public void setCreatredAtEnterprise(Date creatredAtEnterprise) {
        this.creatredAtEnterprise = creatredAtEnterprise;
    }



    public Date getUpdatedAtEnterprise() {
        return updatedAtEnterprise;
    }



    public void setUpdatedAtEnterprise(Date updatedAtEnterprise) {
        this.updatedAtEnterprise = updatedAtEnterprise;
    }



}
