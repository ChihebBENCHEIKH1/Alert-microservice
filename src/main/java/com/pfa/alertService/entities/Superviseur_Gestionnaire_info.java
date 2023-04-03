package com.pfa.alertService.entities;

public class Superviseur_Gestionnaire_info {
	private Long idSuperviseur;
	private Long idGestionnaire;
	public Superviseur_Gestionnaire_info(Long idSuperviseur, Long idGestionnaire) {
		super();
		this.idSuperviseur = idSuperviseur;
		this.idGestionnaire = idGestionnaire;
	}
	public Superviseur_Gestionnaire_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSuperviseur() {
		return idSuperviseur;
	}
	public void setIdSuperviseur(Long idSuperviseur) {
		this.idSuperviseur = idSuperviseur;
	}
	public Long getIdGestionnaire() {
		return idGestionnaire;
	}
	public void setIdGestionnaire(Long idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}
	
}
