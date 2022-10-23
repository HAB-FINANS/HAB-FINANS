package com.habfinans.habfinans.service;

import java.util.List;

import com.habfinans.habfinans.Models.Enterprise;


public interface ServiceInterfaceEnterprise {
    //Metodo para ver lista de enterprise
    public List<Enterprise> getEnterprise();

    //Metodo que trae un Enterprise
    public Enterprise getOnlyOneEnterprise(Long idEnterprise) throws Exception;

    //Metodo que crea una Enterprise
    public String getCreateEnterprise(Enterprise enterpriseIn);

    //Metodo que permite actualizar una enterprise
    public Enterprise getUpdateEnterprise(Enterprise enterpriseIn) throws Exception;

    //Metodo que elimina una enterprise
    public String getDeleteEnterprise(Long idEnterprise) throws Exception;

}
