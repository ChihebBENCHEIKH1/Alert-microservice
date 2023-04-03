package com.pfa.alertService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@DiscriminatorValue("Gestionnaire")
public class Gestionnaire extends User {
public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
public Gestionnaire(Long id, String email, String username) {
		super(id, email, username);
		// TODO Auto-generated constructor stub
	}

public Gestionnaire(Long id, String email, String username,Superviseur superviseurs, List<Alert> alerts) {
	super(id, email, username);
	this.superviseur = superviseurs;
	this.alerts = alerts;
}



@OneToOne(cascade = CascadeType.ALL)
private Superviseur superviseur;
@OneToMany()
private List<Alert> alerts=new ArrayList<>();
public List<Alert> getAlerts() {
	return alerts;
}
public Superviseur getSuperviseur() {
	return superviseur;
}
public void setSuperviseur(Superviseur superviseur) {
	this.superviseur = superviseur;
}
public void setAlerts(List<Alert> alerts) {
	this.alerts = alerts;
}
}
