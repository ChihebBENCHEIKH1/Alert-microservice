package com.pfa.alertServices.service;

import java.util.List;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.entities.Gestionnaire_alert;
import com.pfa.alertService.entities.RequestOBjectOfaffectation;
import com.pfa.alertService.entities.Superviseur_Gestionnaire_info;

public interface Alert_User_Service {
	public List<AlertDto> getAllAlertOfSuperviseur(Long id);
	public List<AlertDto> getAllAlertOfGestionnaire(Long id);
	public List<AlertDto> getAllGestionnairesAlertsManagedBySuperviseurIdentifiedById(Long idSuperviseur
			,Long idGestionnaire);
	public List<AlertDto> addAlertToSuperviseur(RequestOBjectOfaffectation bjectOfaffectation);
	public List<AlertDto> addAlertToGestionnaire(Gestionnaire_alert gestionnaire_alert);
	public void deleteAlertFromSuperviseur(RequestOBjectOfaffectation bjectOfaffectation);
	public void deleteAlertFromGestionnaire(Long id,Long alertid);
}
