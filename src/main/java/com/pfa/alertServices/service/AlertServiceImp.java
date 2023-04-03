package com.pfa.alertServices.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.alertService.dao.AlertRepository;
import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertService.mappers.AlertMapper;
import com.pfa.alertService.mappers.AttachementMapper;
import com.pfa.alertService.mappers.FollowUpMapper;

@Service
@Transactional
public class AlertServiceImp implements AlertService {

	@Autowired
	private AlertRepository alertRepository;
	@Autowired
	private AlertMapper alertMapper;
	@Autowired
	private FollowUpMapper followUpMapper;
	@Autowired
	private AttachementMapper attachementMapper;
	@Override
	public Alert addAlert(Alert alert) {
		return alertRepository.save(alert);
	}

	@Override
	public Alert findAlertById(Long alertId) {
		return alertRepository.findById(alertId).get();
	}

	@Override
	public List<AlertDto> findAllAlerts() {
		return alertRepository.findAll().stream().map(x->new AlertDto(x.getId(),
				x.getCode(), x.getCreationDate(), x.getType(), x.getStatus()
				, x.getDescription())).
				collect(Collectors.toList());
	}

	@Override
	public void deleteAlertById(Long id) {
		alertRepository.deleteById(id);
	}

	@Override
	public AlertDto modifyAlert(Long id,Alert alert) {
		Alert modifiedAlert=alertRepository.findById(id).get();
		modifiedAlert.setCode(alert.getCode());
		modifiedAlert.setAttachements(alert.getAttachements());
		modifiedAlert.setCreationDate(alert.getCreationDate());
		modifiedAlert.setDescription(alert.getDescription());
		modifiedAlert.setFollowUps(alert.getFollowUps());
		modifiedAlert.setGestionnaires(alert.getGestionnaires());
		modifiedAlert.setId(alert.getId());
		modifiedAlert.setStatus(alert.getStatus());
		modifiedAlert.setType(alert.getType());
		return alertMapper.alertToAlertDto(alertRepository.save(modifiedAlert));
	}

	@Override
	public AlertDto findAlertByID(Long id) {
		return alertMapper.alertToAlertDto(alertRepository.findById(id).get());
	}

	@Override
	public List<AttachementDto> alertAttachements(Long id) {
		return findAlertById(id).getAttachements().stream().
				map(x->attachementMapper.attachementToAttachementDto(x)).
				collect(Collectors.toList());
	}

	@Override
	public List<FollowUpDto> alertFollowUps(Long id) {
		return findAlertById(id).getFollowUps().stream().
				map(x->followUpMapper.followUpToFollowUpDto(x)).
				collect(Collectors.toList());
	}
}
