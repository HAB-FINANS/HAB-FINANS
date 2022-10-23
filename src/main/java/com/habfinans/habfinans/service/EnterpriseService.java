package com.habfinans.habfinans.service;

/* import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.entities.Enterprise;
import com.habfinans.habfinans.repository.EnterpriseRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional; */

/* import com.habfinans.habfinans.entities.Employee;  */
/* import java.util.List;
import java.util.Date;

import javax.el.ELException;

@Service */
public class EnterpriseService {
    //Para traer la fecha actual
    //Attribute
/*     Date Today = new Date();


    //Inyectar un objeto del repositorio de la entida enterprise
    @Autowired
    private EnterpriseRepository repository;


    //Metodo para ver la lista de Enterprise 
    public List<Enterprise> getEnterprise(){
        return repository.findAll();
    } 

    //Devolver solo una empresa
    public Enterprise getOnlyOnEnterprise(Long idEnterprise) throws Exception{
        Optional<Enterprise> EnterpriseBD = EnterpriseRepository.findById(idEnterprise);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("IdEnterprise no asignado a ninguna enterprise en nuestra base de datos");
    }

    //Metodo que crea una enterprise
    public boolean createEnterprise(Enterprise enterprise){
        try{
            //Preguntar si ya hay una empresa con ese ID
            Optional<Enterprise> EnterpriseBD = EnterpriseRepository.findById(enterprise.getEnterprise());
            if(!EnterpriseBD.isPresent()){


                repository.save(enterprise);
                return true;
        }
    }
        catch (Exception e){
            return false;
        }
    } 

    //Metodo que permite actualizar una enterprise
    public Enterprise getUpdateEnterprise(Enterprise enterprise) throws Exception{
        return null;
    }
    

    //Metodo que elimina una enterprise
    public String getDeleteEnterprise(Long idEnterprise) throws Exception{

        return null;
    } */

}
