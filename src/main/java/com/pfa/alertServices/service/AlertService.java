package com.pfa.alertServices.service;

import java.util.List;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.Alert;

public interface AlertService {
	public Alert addAlert(Alert alert);
	public Alert findAlertById(Long id);
	public AlertDto findAlertByID(Long id);
	public List<AlertDto> findAllAlerts();
	public void deleteAlertById(Long id);
	public AlertDto modifyAlert(Long id,Alert alert);
	public List<AttachementDto> alertAttachements(Long id);
	public List<FollowUpDto> alertFollowUps(Long id);
}
