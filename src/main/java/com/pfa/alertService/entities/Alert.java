package com.pfa.alertService.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Alert {
	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String code;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	private String type;
	private String status;
	private String description;
	@OneToMany(mappedBy = "alert",cascade = CascadeType.ALL)
	private List<FollowUp> followUps=new ArrayList<>();
	@OneToMany(mappedBy = "alert",cascade = CascadeType.ALL)
	private List<Attachement> attachements=new ArrayList<>();
	@ManyToOne(cascade = CascadeType.ALL)
	private Gestionnaire gestionnaire;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="alert_superviseur"
			,joinColumns = @JoinColumn(name="alert_id"),
			inverseJoinColumns  = @JoinColumn(name="superviseur_id"))
	private List<Superviseur> superviseurs=new ArrayList<>();
	public Alert(Long id, String code, Date creationDate, String type, String status, String description) {
		super();
		this.id = id;
		this.code = code;
		this.creationDate = creationDate;
		this.type = type;
		this.status = status;
		this.description = description;
	}
	
	public Alert(Long id, String code, Date creationDate, String type, String status, String description,
			List<FollowUp> followUps, List<Attachement> attachements, Gestionnaire gestionnaire,
			List<Superviseur> superviseurs) {
		super();
		this.id = id;
		this.code = code;
		this.creationDate = creationDate;
		this.type = type;
		this.status = status;
		this.description = description;
		this.followUps = followUps;
		this.attachements = attachements;
		this.gestionnaire = gestionnaire;
		this.superviseurs = superviseurs;
	}
	public List<Superviseur> getGestionnaires() {
		return superviseurs;
	}
	public void setGestionnaires(List<Superviseur> gestionnaires) {
		this.superviseurs = gestionnaires;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<FollowUp> getFollowUps() {
		return followUps;
	}
	public void setFollowUps(List<FollowUp> followUps) {
		this.followUps = followUps;
	}
	public List<Attachement> getAttachements() {
		return attachements;
	}
	public void setAttachements(List<Attachement> attachements) {
		this.attachements = attachements;
	}
	
	
	

}
