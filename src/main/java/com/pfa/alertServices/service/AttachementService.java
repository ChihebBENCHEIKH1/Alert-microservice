package com.pfa.alertServices.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.entities.Attachement;

public interface AttachementService {
	public Attachement addAttachementToAlert(AttachementDto attachement,Long id);
	public Attachement getAttachementById(Long id);
	public List<Attachement> geAttachements();
	public void deleteAttachementById(Long id);
	public String uploadFile(MultipartFile file,Long id,String description) throws IOException;
}
