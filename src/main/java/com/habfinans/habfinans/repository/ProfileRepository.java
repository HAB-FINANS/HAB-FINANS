package com.habfinans.habfinans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habfinans.habfinans.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}