package com.pfa.alertServices.service;

import java.util.List;

import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.FollowUp;

public interface FollowUpService {
	public FollowUp addFollowUpToAlert(FollowUpDto followUp,Long id);
	public FollowUp getFollowUpById(Long id);
	public List<FollowUp> geFollowUps();
	public void deleteFollowUpById(Long id);

}
