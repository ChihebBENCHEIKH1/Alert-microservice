package com.pfa.alertService.mappers;

import org.mapstruct.Mapper;

import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.entities.Attachement;

@Mapper(componentModel = "spring")
public interface AttachementMapper {
	public AttachementDto attachementToAttachementDto(Attachement attachement);
}
