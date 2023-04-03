package com.pfa.alertService.dto;

import java.util.Date;

public class FollowUpDto {
	private Long id;
	private String commentaire;
	private java.util.Date date;
	public FollowUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FollowUpDto(Long id, String commentaire, Date date) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.date = date;
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
	
}
