package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habfinans.habfinans.Models.Enterprise;

public interface RepositoryEnterprise extends JpaRepository<Enterprise, Long>{
    
}
