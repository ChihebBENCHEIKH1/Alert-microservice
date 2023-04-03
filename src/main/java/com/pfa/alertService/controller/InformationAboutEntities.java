package com.pfa.alertService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.UserDto;
import com.pfa.alertServices.service.Alert_User_Service;
import com.pfa.alertServices.service.Superviseur_Gestionnaire_Service;
/****************TESTED & WORK SUCCESSFULLY*************/
@RestController
@RequestMapping("/show")
public class InformationAboutEntities {
	@Autowired
	private Superviseur_Gestionnaire_Service gestionnaire_Service;
	@Autowired
	private Alert_User_Service alert_User_Service;
	@GetMapping("/superviseur/{id}/gestionnaires")/*tested*/
	public List<UserDto> gestionnaireOfSuperviseur(@PathVariable Long id)
	{
		return gestionnaire_Service.getAllGestionnaire(id);
	}
	@GetMapping("/superviseur/{id}/alerts")/*tested*/
	public List<AlertDto> superviseurAlerts(@PathVariable Long id)
	{
		return alert_User_Service.getAllAlertOfSuperviseur(id);
	}
	@GetMapping("/gestionnaire/{id}/alerts")/*tested*/
	public List<AlertDto> gestionnairerAlerts(@PathVariable Long id)
	{
		return alert_User_Service.getAllAlertOfGestionnaire(id);
	}
	@GetMapping("/superviseur/{superviseurId}/gestionnaire/{gestionnaireId}/alerts")/*tested*/
	public List<AlertDto> alertsOfGestionnaireSupervisedBySuperviseur(
			@PathVariable(name = "superviseurId") Long superviseurId,
			@PathVariable(name = "gestionnaireId") Long gestionnaireId)
	{
		return alert_User_Service.getAllGestionnairesAlertsManagedBySuperviseurIdentifiedById
				(superviseurId, gestionnaireId);
	}
	
}
