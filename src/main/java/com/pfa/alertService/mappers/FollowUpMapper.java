package com.pfa.alertService.mappers;

import org.mapstruct.Mapper;

import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.FollowUp;

@Mapper(componentModel = "spring")
public interface FollowUpMapper {
		public FollowUpDto followUpToFollowUpDto(FollowUp followUp);

}
