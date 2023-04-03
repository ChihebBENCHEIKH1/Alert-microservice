package com.pfa.alertService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@DiscriminatorValue("Superviseur")
public class Superviseur extends User{
	
	
	public Superviseur(Long id, String email, String username,List<Gestionnaire> gestionnaires, List<Alert> alerts) {
		super(id, email, username);
		this.gestionnaires = gestionnaires;
		this.alerts = alerts;
	}
	public List<Alert> getAlerts() {
		return alerts;
	}
	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Superviseur(Long id, String email, String username) {
		super(id, email, username);
	}
	
	public Superviseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Gestionnaire> getGestionnaires() {
		return gestionnaires;
	}
	public void setGestionnaires(List<Gestionnaire> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Gestionnaire> gestionnaires;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="alert_superviseur"
			,joinColumns = @JoinColumn(name="superviseur_id"),
			inverseJoinColumns  = @JoinColumn(name="alert_id"))
	private List<Alert> alerts=new ArrayList<>();
}
