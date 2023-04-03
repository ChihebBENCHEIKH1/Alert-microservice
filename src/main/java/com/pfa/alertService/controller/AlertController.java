package com.pfa.alertService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.alertService.dto.AlertDto;
import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertServices.service.AlertService;

@RestController
@RequestMapping("/alert")
public class AlertController {
	@Autowired
	private AlertService alertService;
	
	@GetMapping("/all")
	public List<AlertDto> allAlerts()
	{
		return alertService.findAllAlerts();
	}
	@GetMapping("/{id}/followUp")
	public List<FollowUpDto> allFollowUpOfAlert(@PathVariable Long id)
	{
		return alertService.alertFollowUps(id);
	}
	@GetMapping("/{id}/attachements")/*tested*/
	public List<AttachementDto> allAttachementsOfAlert(@PathVariable Long id)
	{
		return alertService.alertAttachements(id);
	}
	@GetMapping("/{id}")
	public AlertDto getAlertById(@PathVariable Long id)
	{
		return alertService.findAlertByID(id);
	}
	@PostMapping("/add")
	public void addAlert(@RequestBody Alert alert)
	{
		 alertService.addAlert(alert);
	}
	@PutMapping("/update/{id}")
	public AlertDto updateAlert(@RequestBody Alert alert,@PathVariable Long id)
	{
		return alertService.modifyAlert(id,alert);
	}
	@DeleteMapping("{id}")
	public void deleteAlert(@PathVariable Long id)
	{
		alertService.deleteAlertById(id);
	}
}
