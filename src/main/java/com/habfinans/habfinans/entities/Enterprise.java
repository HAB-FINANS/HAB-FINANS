package com.habfinans.habfinans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="enterprises")


public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="nit")
    private String nit;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="created_at")
    private LocalDate created_at;

    @Column(name="updated_at")
    private LocalDate updated_at;

    
/* 
    public Enterprise(String name, String nit, String address, String phone, LocalDate created_at,
    LocalDate updated_at) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    } */



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getNit() {
        return nit;
    }



    public void setNit(String nit) {
        this.nit = nit;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public LocalDate getCreated_at() {
        return created_at;
    }



    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }



    public LocalDate getUpdated_at() {
        return updated_at;
    }



    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }


    
    

}
