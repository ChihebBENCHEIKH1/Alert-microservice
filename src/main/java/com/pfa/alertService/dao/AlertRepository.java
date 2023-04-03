package com.pfa.alertService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.alertService.entities.Alert;

@Repository
public interface AlertRepository extends JpaRepository< Alert,Long> {

}
