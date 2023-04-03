package com.pfa.alertServices.service;

import java.util.Date;
import java.util.List;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.FollowUp;
import com.pfa.alertService.entities.Gestionnaire_alert;
import com.pfa.alertService.entities.RequestOBjectOfaffectation;
import com.pfa.alertService.entities.Superviseur_Gestionnaire_info;

public interface Superviseur_Gestionnaire_Service {
	public List<UserDto> getAllGestionnaire(Long id);
	public UserDto addGestionnaireToSuperviseur(Long idGestionnaire,Long idSuperviseur);
	public void retrieveGestionnaireFromSuperviseur(Long idGestionnaire,Long idSuperviseur);
	public AlertDto closeAlertForGestionnaire(Gestionnaire_alert gestionnaire_alert,
			Long superviseur_id,String description,Date date);
	public AlertDto reopenAlertForGestionnaire(Gestionnaire_alert gestionnaire_alert,
			Long superviseur_id,String description,Date date);
}
