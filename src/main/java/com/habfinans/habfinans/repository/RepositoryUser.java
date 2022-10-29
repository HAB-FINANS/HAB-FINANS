package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habfinans.habfinans.Models.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long >{

    User findByUsername(String username);
    
}
