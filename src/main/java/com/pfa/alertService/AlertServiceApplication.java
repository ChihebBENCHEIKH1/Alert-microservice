package com.pfa.alertService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Streams;
import org.springframework.context.annotation.Bean;

import com.pfa.alertService.dao.AlertRepository;
import com.pfa.alertService.dao.AttachementRepository;
import com.pfa.alertService.dao.FollowUpRepository;
import com.pfa.alertService.dao.Gestionnaireepository;
import com.pfa.alertService.dao.SuperviseurRepository;
import com.pfa.alertService.entities.Admin;
import com.pfa.alertService.entities.Alert;
import com.pfa.alertService.entities.Attachement;
import com.pfa.alertService.entities.FollowUp;
import com.pfa.alertService.entities.Gestionnaire;
import com.pfa.alertService.entities.Superviseur;
import com.pfa.alertService.entities.User;

@SpringBootApplication(scanBasePackages = {
		"com.pfa.alertService.controller",
		"com.pfa.alertServices.service",
		"com.pfa.alertService.dao",
		"com.pfa.alertService.entities",
		"com.pfa.alertService.mappers"
})
public class AlertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertServiceApplication.class, args);
	}
	
	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(AlertRepository alertRepository, Gestionnaireepository userRepository,
	        FollowUpRepository followUpRepository, AttachementRepository attachementRepository,
	        SuperviseurRepository repository) {
	    return args -> {

	        Superviseur s1 = new Superviseur(null, "s@yahoo.fr", "superviseir");
	        Gestionnaire user = new Gestionnaire(null, "admin@root.tn", "root", s1, null);
	        Gestionnaire user1 = new Gestionnaire(null, "mounir@root.tn", "mounir", s1, null);
	        Gestionnaire user2 = new Gestionnaire(null, "lam3i@root.tn", "lam3i", s1, null);
	        
	       /* List<FollowUp> followUps = new ArrayList<>();
	        followUps.add(followUp2);
	        followUps.add(followUp1);
	        followUps.add(followUp);*/
	        List<Gestionnaire> list = new ArrayList<>();
	        list.add(user);
	        list.add(user2);
	        list.add(user1);
	        s1.setGestionnaires(list);
	        List<Superviseur> list2 = new ArrayList<>();
	        list2.add(s1);
	        Alert alert = new Alert(null, "xd", new Date(), "rien", "rien", "rien", new ArrayList<>(), new ArrayList<Attachement>(),
	                user, list2);
	        FollowUp followUp = new FollowUp(null, "bla", new Date(), alert);
	        FollowUp followUp1 = new FollowUp(null, "bla", new Date(), alert);
	        FollowUp followUp2 = new FollowUp(null, "bla", new Date(), alert);
	        Attachement attachement = new Attachement(null, "bla", "bla", alert);
	        Attachement attachement1 = new Attachement(null, "bla", "bla", alert);
	        alert.getAttachements().add(attachement1);
	        alert.getFollowUps().add(followUp2);
	        s1.getAlerts().add(alert);
	        ArrayList<Alert> alerts= new ArrayList<>();
	        alerts.add(alert);
	        List<FollowUp> followUps = new ArrayList<>();
	        followUps.add(followUp2);
	        followUps.add(followUp1);
	        followUps.add(followUp);
	        alert.setFollowUps(followUps);
	        // Save the Attachement entities first
	        attachementRepository.save(attachement);
	        attachementRepository.save(attachement1);
	        followUpRepository.save(followUp);
	        followUpRepository.save(followUp1);
	        // Save the other entities
	        user.setAlerts(alerts);
	        userRepository.save(user);
	        userRepository.save(user1);
	        userRepository.save(user2);
	       // alertRepository.save(alert);
	       
	        repository.save(s1);
	    };
	}

}
