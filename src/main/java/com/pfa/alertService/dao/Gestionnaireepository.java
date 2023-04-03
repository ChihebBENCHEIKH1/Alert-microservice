package com.pfa.alertService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;

@Repository
public interface Gestionnaireepository extends JpaRepository< Gestionnaire,Long> {
	public Gestionnaire findByEmail(String email);
	public List<Gestionnaire> findBySuperviseur(Superviseur superviseur);
}
