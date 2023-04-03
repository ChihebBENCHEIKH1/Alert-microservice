package com.pfa.alertServices.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.alertService.dao.Gestionnaireepository;
import com.pfa.alertService.dao.SuperviseurRepository;
import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertService.entities.User;
import com.pfa.alertService.mappers.UserMapper;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	private Gestionnaireepository gestionnaireepository ;
	@Autowired
	private SuperviseurRepository superviseurRepository; 
	@Autowired
	private UserMapper mapper;

	@Override
	public UserDto addGestionnaire(Gestionnaire user) {
		return mapper.gestionnaireToUserDto( gestionnaireepository.save(user));
	}

	@Override
	public List<UserDto> getAllGestionnaires() {
		return  gestionnaireepository.findAll().stream().map(x->mapper.gestionnaireToUserDto(x))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto getGestionnaireById(Long id) {
		return mapper.gestionnaireToUserDto( gestionnaireepository.findById(id).get());
	}

	@Override
	public UserDto getGestionnaireByEmail(String email) {
		return mapper.gestionnaireToUserDto(gestionnaireepository.findByEmail(email));
	}

	@Override
	public void deleteGestionnairerById(Long id) {
		gestionnaireepository.deleteById(id);
	}

	@Override
	public UserDto addSuperviseur(Superviseur user) {
		return mapper.superviseurToUserDto(superviseurRepository.save(user));
	}

	@Override
	public List<UserDto> getAllSuperviseurs() {
		return superviseurRepository.findAll().stream().map(x->mapper.superviseurToUserDto(x))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto getSuperviseurById(Long id) {
		return mapper.superviseurToUserDto(superviseurRepository.findById(id).get());
	}

	@Override
	public UserDto getSuperviseurByEmail(String email) {
		return mapper.superviseurToUserDto(superviseurRepository.findByEmail(email));
	}

	@Override
	public void deleteSuperviseurById(Long id) {
		superviseurRepository.deleteById(id);
	}

	@Override
	public UserDto updateGestionnaire(Gestionnaire gestionnaire) {
		Gestionnaire gestionnaireModifier=new Gestionnaire();
		gestionnaireModifier.setAlerts(gestionnaire.getAlerts());
		gestionnaireModifier.setEmail(gestionnaire.getEmail());
		gestionnaireModifier.setId(gestionnaire.getId());
		gestionnaireModifier.setSuperviseur(gestionnaire.getSuperviseur());
		gestionnaireModifier.setUsername(gestionnaire.getUsername());

		return mapper.gestionnaireToUserDto(gestionnaireepository.save(gestionnaireModifier));
	}

	@Override
	public UserDto updateSuperviseur(Superviseur superviseur) {
		Superviseur superviseurModifier=new Superviseur();
		superviseurModifier.setAlerts(superviseur.getAlerts());
		superviseurModifier.setEmail(superviseur.getEmail());
		superviseurModifier.setGestionnaires(superviseur.getGestionnaires());
		superviseurModifier.setId(superviseur.getId());
		superviseurModifier.setUsername(superviseur.getUsername());
		return mapper.superviseurToUserDto(superviseurRepository.save(superviseurModifier));
	}
}
