package com.habfinans.habfinans.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.Models.Enterprise;
import com.habfinans.habfinans.repository.RepositoryEnterprise;

@Service
public class ServiceEnterprise implements ServiceInterfaceEnterprise{

    //Attribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad enterprise
    @Autowired
    RepositoryEnterprise repositoryEnterprise;
    

    @Override
    public String getCreateEnterprise(Enterprise enterpriseIn) {
        //Preguntar si ya existe una enterprise con ese ID
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(enterpriseIn.getIdEnterprise());
        if(!EnterpriseBD.isPresent()){
            repositoryEnterprise.save(enterpriseIn);
            return ("Enterprise creada con exito");
        }
        return ("Ese Id ya está asignado a una enterprise existente");
    }

    @Override
    public String getDeleteEnterprise(Long idEnterprise) throws Exception {
        Optional<Enterprise> enterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(enterpriseBD.isPresent()){
            repositoryEnterprise.deleteById(idEnterprise);
            return ("Enterprise eliminada con exito");
        }
        throw new Exception("Enterprise no encontrada");
    }

    @Override
    public List<Enterprise> getEnterprise() {
        return repositoryEnterprise.findAll();
    }

    @Override
    public Enterprise getOnlyOneEnterprise(Long idEnterprise) throws Exception {
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("IdEnterprise no asignado a ninguna en la base de datos");
    }

    @Override
    public Enterprise getUpdateEnterprise(Enterprise enterpriseIn) throws Exception {
        //Llamamos a la enterprise a actualizar en la BD
        Enterprise enterpriseBD = getOnlyOneEnterprise(enterpriseIn.getIdEnterprise());

        //Actualizamos los atributos
        if(enterpriseIn.getNameEnterprise()!=null && !enterpriseIn.getNameEnterprise().equals("")){
            enterpriseBD.setNameEnterprise(enterpriseIn.getNameEnterprise());
        }

        if(enterpriseIn.getNITEnterprise()!=null && !enterpriseIn.getNITEnterprise().equals("")){
            enterpriseBD.setNITEnterprise(enterpriseIn.getNITEnterprise());
        }

        if(enterpriseIn.getAddressEnterprise()!=null && !enterpriseIn.getAddressEnterprise().equals("")){
            enterpriseBD.setAddressEnterprise(enterpriseIn.getAddressEnterprise());
        }

        if(enterpriseIn.getPhoneEnterprise()!=null && !enterpriseIn.getPhoneEnterprise().equals("")){
            enterpriseBD.setPhoneEnterprise(enterpriseIn.getPhoneEnterprise());
        }

        enterpriseBD.setUpdatedAtEnterprise(Today);
        
        return repositoryEnterprise.save(enterpriseBD);
    }
    
}
