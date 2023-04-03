package com.pfa.alertServices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.alertService.dao.AlertRepository;
import com.pfa.alertService.dao.FollowUpRepository;
import com.pfa.alertService.dto.FollowUpDto;
import com.pfa.alertService.entities.FollowUp;

@Service
@Transactional
public class FollowUpServiceImp implements FollowUpService {

	@Autowired
	private FollowUpRepository followUpRepository;
	@Autowired 
	private AlertRepository alertRepository;
	@Override
	public FollowUp addFollowUpToAlert(FollowUpDto followUp,Long id) {
		FollowUp followUpToBeSaved=new FollowUp(followUp.getId(),
				followUp.getCommentaire(), followUp.getDate(), alertRepository.findById(id).get());
		return followUpRepository.save(followUpToBeSaved);
	}

	@Override
	public FollowUp getFollowUpById(Long id) {
		return followUpRepository.findById(id).get();
	}

	@Override
	public List<FollowUp> geFollowUps() {
		return followUpRepository.findAll();
	}

	@Override
	public void deleteFollowUpById(Long id) {
		followUpRepository.deleteById(id);
	}


}
