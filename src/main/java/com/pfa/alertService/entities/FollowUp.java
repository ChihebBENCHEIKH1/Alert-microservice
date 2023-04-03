package com.pfa.alertService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
public class FollowUp {
	public FollowUp(Long id, String commentaire, java.util.Date date, Alert alert) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.date = date;
		this.alert = alert;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public Alert getAlert() {
		return alert;
	}
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String commentaire;
	private java.util.Date date;
	public FollowUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Alert alert;
}
