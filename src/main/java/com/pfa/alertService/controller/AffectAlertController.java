package com.pfa.alertService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.RequestOBjectOfaffectation;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertServices.service.AlertService;
import com.pfa.alertServices.service.Alert_User_Service;
import com.pfa.alertServices.service.UserService;

@RestController
public class AffectAlertController {
	@Autowired
	private UserService userService;
	@Autowired
	private AlertService alertService;
	@Autowired
	private Alert_User_Service alert_User_Service;
	
	@PostMapping("/superviseur/affect")
	public List<AlertDto> affecteAlert(@RequestBody RequestOBjectOfaffectation objectOfaffectation)
	{
		return alert_User_Service.addAlertToSuperviseur(objectOfaffectation);
		
	}
	@DeleteMapping("/superviseur/unaffect")
	public void unaffectAlert( @RequestBody  RequestOBjectOfaffectation objectOfaffectation)
	{
		alert_User_Service.deleteAlertFromSuperviseur(objectOfaffectation);
	}
	

}
