package com.habfinans.habfinans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.entities.Profile;
import com.habfinans.habfinans.repository.ProfileRepository;
/* import com.habfinans.habfinans.entities.Employee;  */
import java.util.List;


@Service

public class ProfileService {
    @Autowired
    private ProfileRepository repository;

    public List<Profile> getProfile(){
        return repository.findAll();
    } 

    public boolean createProfile(Profile profile){
        try{

        repository.save(profile);
            return true;
        }
catch (Exception e){
    return false;
}
    } 
}
