package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habfinans.habfinans.Models.Employee;

public interface RepositoryEmployee  extends JpaRepository<Employee, Long>{
    
}
