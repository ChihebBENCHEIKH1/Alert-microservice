package com.pfa.alertService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.alertService.entities.Attachement;

@Repository
public interface AttachementRepository extends JpaRepository< Attachement,Long> {
	Optional<Attachement> findByTitle(String title);
}
