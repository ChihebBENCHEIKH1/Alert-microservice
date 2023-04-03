package com.pfa.alertServices.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pfa.alertService.dao.AlertRepository;
import com.pfa.alertService.dao.AttachementRepository;
import com.pfa.alertService.dto.AttachementDto;
import com.pfa.alertService.entities.Attachement;

@Service
@Transactional
public class AttachementServiceImp implements AttachementService {

	@Autowired
	private AttachementRepository attachementRepository;
	@Autowired
	private AlertRepository alertRepository;
	@Override
	public Attachement addAttachementToAlert(AttachementDto attachement,Long id) {
		Attachement attachementToBeSaved=new Attachement(
				attachement.getId(),attachement.getTitle(),attachement.getDescription(),
				alertRepository.findById(id).get());
		return attachementRepository.save(attachementToBeSaved);
	}

	@Override
	public Attachement getAttachementById(Long id) {
		return attachementRepository.findById(id).get();
	}

	@Override
	public List<Attachement> geAttachements() {
		return attachementRepository.findAll();
	}

	@Override
	public void deleteAttachementById(Long id) {
		attachementRepository.deleteById(id);
	}

	@Override
	public String uploadFile(MultipartFile file,Long id,String description) throws IOException {
		Attachement attachement= attachementRepository.save(new Attachement(null,file.getOriginalFilename()
				,description,file.getContentType(),file.getBytes(),alertRepository.findById(id).get()));
		if(attachement!=null)
			return "file "+ file.getOriginalFilename()+"."+
		file.getContentType()+" uploaded successfully";
		return null;
	}

}
