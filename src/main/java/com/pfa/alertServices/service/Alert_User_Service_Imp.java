package com.pfa.alertServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.alertService.dao.Gestionnaireepository;
import com.pfa.alertService.dao.SuperviseurRepository;
import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Gestionnaire_alert;
import com.pfa.alertService.entities.RequestOBjectOfaffectation;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertService.entities.Superviseur_Gestionnaire_info;
import com.pfa.alertService.mappers.AlertMapper;
import com.pfa.alertService.mappers.UserMapper;

@Service
@Transactional
public class Alert_User_Service_Imp implements Alert_User_Service {

	@Autowired
	private AlertService alertService;
	@Autowired
	private SuperviseurRepository superviseurRepository;
	@Autowired
	private Gestionnaireepository gestionnaireepository;
	@Autowired
	private AlertMapper alertMapper;
	@Override
	public List<AlertDto> getAllAlertOfSuperviseur(Long id) {
		Superviseur superviseur=superviseurRepository.findById(id).get();
		List<AlertDto> alerts=new ArrayList<>();
		superviseur.getAlerts().forEach(x->{
			AlertDto alertDto=alertMapper.alertToAlertDto(x);
			alerts.add(alertDto);
		});
		return alerts;
	}

	@Override
	public List<AlertDto> getAllAlertOfGestionnaire(Long id) {
		Gestionnaire gestionnaire=gestionnaireepository.findById(id).get();
		List<AlertDto> alerts=new ArrayList<>();
		gestionnaire.getAlerts().forEach(x->{
			AlertDto alertDto=alertMapper.alertToAlertDto(x);
			alerts.add(alertDto);
		});
		return alerts;
	}

	@Override
	public List<AlertDto> addAlertToSuperviseur(RequestOBjectOfaffectation bjectOfaffectation) {
		Alert alert=alertService.findAlertById(bjectOfaffectation.getIdAlert());
		alert.setStatus("en cours");
		superviseurRepository.findById(bjectOfaffectation.getIdSuperviseur()).get()
		.getAlerts().add(alert);
		alertService.modifyAlert(alert.getId(), alert);
		return superviseurRepository.findById(bjectOfaffectation.getIdSuperviseur()).get()
				.getAlerts().stream().map(x->alertMapper.alertToAlertDto(x))
				.collect(Collectors.toList()
						);
	}

	@Override
	public void deleteAlertFromSuperviseur(RequestOBjectOfaffectation bjectOfaffectation) {
		Alert alert=alertService.findAlertById(bjectOfaffectation.getIdAlert());
		superviseurRepository.findById(bjectOfaffectation.getIdSuperviseur()).get()
		.getAlerts().remove(alert);
		gestionnaireepository.findBySuperviseur(superviseurRepository.findById(
				bjectOfaffectation.getIdSuperviseur()).get()).forEach(g->{
					g.getAlerts().remove(alertService.findAlertById(bjectOfaffectation.getIdAlert()));
				});
	}

	@Override
	public List<AlertDto> addAlertToGestionnaire(Gestionnaire_alert gestionnaire_alert) {
		gestionnaireepository.findById(gestionnaire_alert.getGestionnaireId()).get()
		.getAlerts().add(alertService.findAlertById(gestionnaire_alert.getAlertId()));
		return gestionnaireepository.findById(gestionnaire_alert.getGestionnaireId()).get()
				.getAlerts().stream().map(x->alertMapper.alertToAlertDto(x)).collect
				(Collectors.toList());
	}

	@Override
	public List<AlertDto> getAllGestionnairesAlertsManagedBySuperviseurIdentifiedById
	(
			Long idSuperviseur,Long idGestionnaire) {
		List<AlertDto> alertDtos=new ArrayList<>();
		 superviseurRepository.findById(idSuperviseur).
				get().getGestionnaires().forEach(g->{
					if(g.getId()==idGestionnaire)
						g.getAlerts().forEach(a->alertDtos.add( alertMapper.alertToAlertDto(a)));
				});
		 return alertDtos;
	}

	@Override
	public void deleteAlertFromGestionnaire(Long id,Long alertid) {
		gestionnaireepository.findById(id).get()
		.getAlerts().remove(alertService.findAlertById(alertid));
		
	}

}
