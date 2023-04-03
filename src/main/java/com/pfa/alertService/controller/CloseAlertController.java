package com.pfa.alertService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.entities.Alert_gestionnaire_followUp_info;
import com.pfa.alertServices.service.Superviseur_Gestionnaire_Service;

@RestController
public class CloseAlertController {
	@Autowired
	private Superviseur_Gestionnaire_Service superviseur_Gestionnaire_Service;
	@PostMapping("/gestionnaire/supervisedBy/{idSuperviseur}/close-alert")
	public AlertDto closeAlertToGestionnaire(@PathVariable(name="idSuperviseur") Long id	,
			@RequestBody Alert_gestionnaire_followUp_info info	)
	{
		System.out.println(info.getComment());
		return superviseur_Gestionnaire_Service.closeAlertForGestionnaire(info.getGestionnaire_alert(),
				id, info.getComment(), info.getDate());
	}
	
	

}
