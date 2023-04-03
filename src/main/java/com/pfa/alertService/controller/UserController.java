package com.pfa.alertService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertServices.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	private UserService userService;
	
	@GetMapping("/allGestionnaire")/*tested*/
	public List<UserDto> allGestionnaires()
	{
		return userService.getAllGestionnaires();
	}
	@GetMapping("/gestionnaire/{id}")/*tested*/
	public UserDto getGestionnaireById(@PathVariable Long id)
	{
		return userService.getGestionnaireById(id);
	}
	@PostMapping("/addGestionnaire")/*tested*/
	public UserDto addGestionnaire(@RequestBody Gestionnaire gestionnaire)
	{
		return userService.addGestionnaire(gestionnaire);
	}
	@DeleteMapping("/gestionnaire/{id}")/*tested*/
	public void deleteGestionnare(@PathVariable Long id)
	{
		userService.deleteGestionnairerById(id);
	}
	@GetMapping("/allSuperviseur")/*tested*/
	public List<UserDto> allSuperviseur()
	{
		return userService.getAllSuperviseurs();
	}
	@GetMapping("/superviseur/{id}")/*tested*/
	public UserDto getSuperviseurById(@PathVariable Long id)
	{
		return userService.getSuperviseurById(id);
	}
	@PostMapping("/addSuperviseur")/*tested*/
	public UserDto addSuperviseur(@RequestBody Superviseur superviseur)
	{
		return userService.addSuperviseur(superviseur);
	}
	@DeleteMapping("/superviseur/{id}")/*tested*/
	public void deleteSuperviseur(@PathVariable Long id)
	{
		userService.deleteSuperviseurById(id);
	}
}
