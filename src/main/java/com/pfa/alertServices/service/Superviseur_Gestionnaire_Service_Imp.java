package com.pfa.alertServices.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.alertService.dao.AlertRepository;
import com.pfa.alertService.dao.FollowUpRepository;
import com.pfa.alertService.dao.Gestionnaireepository;
import com.pfa.alertService.dao.SuperviseurRepository;
import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertService.entities.FollowUp;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Gestionnaire_alert;
import com.pfa.alertService.entities.Superviseur_Gestionnaire_info;
import com.pfa.alertService.mappers.AlertMapper;
import com.pfa.alertService.mappers.UserMapper;

@Service
@Transactional
public class Superviseur_Gestionnaire_Service_Imp implements Superviseur_Gestionnaire_Service{

	@Autowired
	private UserMapper mapper;
	@Autowired
	private AlertMapper alertMapper;
	@Autowired
	private SuperviseurRepository superviseurRepository;
	@Autowired
	private Gestionnaireepository gestionnaireepository;
	@Autowired
	private AlertRepository alertRepository;
	@Autowired
	private FollowUpRepository followUpRepository;
	private AlertDto alertDto;
	@Override
	public List<UserDto> getAllGestionnaire(Long id) {
		List<UserDto> userDtos=superviseurRepository.findById(id).get()
				.getGestionnaires().stream().map(x->mapper.gestionnaireToUserDto(x)).
				collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto addGestionnaireToSuperviseur(Long idGestionnaire,Long idSuperviseur) {
		 superviseurRepository.findById(idSuperviseur).
				get().getGestionnaires().
				add( gestionnaireepository.findById(idGestionnaire).get());
		 gestionnaireepository.findById(idGestionnaire).get().setSuperviseur(
				 superviseurRepository.findById(idSuperviseur).
					get());
		 return mapper.gestionnaireToUserDto(gestionnaireepository.
				 findById(idGestionnaire).get());
	}

	@Override
	public void retrieveGestionnaireFromSuperviseur(Long idGestionnaire,Long idSuperviseur) {
		superviseurRepository.findById(idSuperviseur).
		get().getGestionnaires().
		remove( gestionnaireepository.findById(idGestionnaire).get());
		gestionnaireepository.findById(idGestionnaire).get().setSuperviseur(null);
		
	}

	@Override
	public AlertDto closeAlertForGestionnaire(Gestionnaire_alert gestionnaire_alert,
			Long superviseur_id,
			String description,
			Date date) {
		
		Alert alert=alertRepository.findById(gestionnaire_alert.getAlertId()).get();
		FollowUp followUpOftheClosedAlert=new FollowUp(null,description,date,alert);
		alert.getFollowUps().add(followUpOftheClosedAlert);
		followUpRepository.save(followUpOftheClosedAlert);
		alertRepository.save(alert);
		Gestionnaire gestionnaire= gestionnaireepository.findById(gestionnaire_alert.getGestionnaireId())
				.get();
		gestionnaire.getAlerts().forEach(x->{
			if(x.getId()==gestionnaire_alert.getAlertId())
				{
					x.setStatus("cloturer");
					alertDto=alertMapper .alertToAlertDto(x);
				}
		});
		superviseurRepository.findById(superviseur_id).get().getGestionnaires().
		forEach(x->{
			x.getAlerts().forEach(y->{
				if(y.getId()==gestionnaire_alert.getAlertId())
					{y.setStatus("cloturer");}
			});
		});
		return alertDto;
	}

	@Override
	public AlertDto reopenAlertForGestionnaire(Gestionnaire_alert gestionnaire_alert, Long superviseur_id,
			String description, Date date) {
		Alert alert=alertRepository.findById(gestionnaire_alert.getAlertId()).get();
		FollowUp followUpOftheClosedAlert=new FollowUp(null,description,date,alert);
		alert.getFollowUps().add(followUpOftheClosedAlert);
		followUpRepository.save(followUpOftheClosedAlert);
		alertRepository.save(alert);
		Gestionnaire gestionnaire= gestionnaireepository.findById(gestionnaire_alert.getGestionnaireId())
				.get();
		gestionnaire.getAlerts().forEach(x->{
			if(x.getId()==gestionnaire_alert.getAlertId())
				{
					x.setStatus("en cours");
					alertDto=alertMapper .alertToAlertDto(x);
				}
		});
		superviseurRepository.findById(superviseur_id).get().getGestionnaires().
		forEach(x->{
			x.getAlerts().forEach(y->{
				if(y.getId()==gestionnaire_alert.getAlertId())
					{y.setStatus("en cours");}
			});
		});
		return alertDto;
	}
}
