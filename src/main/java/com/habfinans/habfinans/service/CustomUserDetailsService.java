package com.habfinans.habfinans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.habfinans.habfinans.Models.User;
import com.habfinans.habfinans.repository.RepositoryUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositoryUser repositoryUser; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        
        User user = repositoryUser.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new CustomUserDetails(user);
    }
    
}
