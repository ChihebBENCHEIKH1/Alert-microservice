package com.pfa.alertService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.UserDto;
import com.pfa.alertServices.service.Superviseur_Gestionnaire_Service;

@RestController
public class GestionnersOfSuperviseurManagementController {

	@Autowired
	private  Superviseur_Gestionnaire_Service superviseur_Gestionnaire_Service;
	@PostMapping("/add/gestionnaire/{idGestionnaire}/to/superviseur/{idSuperviseur}")
	public UserDto addGestionnaireToSuperviseur(
			@PathVariable(name = "idGestionnaire") Long idGestionnaire,
			@PathVariable(name = "idSuperviseur") Long idSuperviseur)
	{
		return superviseur_Gestionnaire_Service.addGestionnaireToSuperviseur
				(idGestionnaire, idSuperviseur);
	}
	@DeleteMapping("remove/gestionnaire/{idGestionnaire}/from/superviseur/{idSuperviseur}")
	public String retrieveGestionnaireToSuperviseur(
			@PathVariable(name = "idGestionnaire") Long idGestionnaire,
			@PathVariable(name = "idSuperviseur") Long idSuperviseur)
	{
		superviseur_Gestionnaire_Service.retrieveGestionnaireFromSuperviseur(
				idGestionnaire, idSuperviseur);
		return "Gestioonaire is no longer managed By manager with the id "+idSuperviseur;
		
	}
}
