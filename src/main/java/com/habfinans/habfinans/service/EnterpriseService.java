package com.habfinans.habfinans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.entities.Enterprise;
import com.habfinans.habfinans.repository.EnterpriseRepository;
/* import com.habfinans.habfinans.entities.Employee;  */
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository repository;

    public List<Enterprise> getEnterprise(){
        return repository.findAll();
    } 

    public boolean createEnterprise(Enterprise enterprise){
        try{

        repository.save(enterprise);
            return true;
        }
catch (Exception e){
    return false;
}
    } 
}
