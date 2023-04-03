package com.pfa.alertService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.alertService.entities.Superviseur;

@Repository
public interface SuperviseurRepository extends JpaRepository<Superviseur, Long> {
	public Superviseur findByEmail(String email);
}
