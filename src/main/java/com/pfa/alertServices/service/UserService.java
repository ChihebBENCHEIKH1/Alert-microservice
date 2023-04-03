package com.pfa.alertServices.service;

import java.util.List;

import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertService.entities.User;

public interface UserService {
	public UserDto addGestionnaire(Gestionnaire user);
	public List<UserDto> getAllGestionnaires();
	public UserDto getGestionnaireById(Long id);
	public UserDto getGestionnaireByEmail(String email);
	public void deleteGestionnairerById(Long id);
	public UserDto addSuperviseur(Superviseur user);
	public List<UserDto> getAllSuperviseurs();
	public UserDto getSuperviseurById(Long id);
	public UserDto getSuperviseurByEmail(String email);
	public void deleteSuperviseurById(Long id);
	public UserDto updateGestionnaire(Gestionnaire gestionnaire);
	public UserDto updateSuperviseur(Superviseur superviseur);
}
