package com.pfa.alertService.mappers;

import org.mapstruct.Mapper;

import com.pfa.alertService.dto.UserDto;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;

@Mapper(componentModel = "spring")
public interface UserMapper {
	public UserDto superviseurToUserDto(Superviseur superviseur);
	public UserDto gestionnaireToUserDto(Gestionnaire gestionnaire);
}
