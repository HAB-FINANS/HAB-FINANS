package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.habfinans.habfinans.entities.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    
}
