package com.pfa.alertService.mappers;

import org.mapstruct.Mapper;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.entities.Alert;

@Mapper(componentModel = "spring")
public interface AlertMapper {
	AlertDto alertToAlertDto(Alert alert);

}
