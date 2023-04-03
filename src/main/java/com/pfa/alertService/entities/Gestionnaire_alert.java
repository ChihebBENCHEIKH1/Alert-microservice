package com.pfa.alertService.entities;

public class Gestionnaire_alert {
	private Long gestionnaireId;
	private Long alertId;
	public Gestionnaire_alert(Long gestionnaireId, Long alertId) {
		super();
		this.gestionnaireId = gestionnaireId;
		this.alertId = alertId;
	}
	public Gestionnaire_alert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getGestionnaireId() {
		return gestionnaireId;
	}
	public void setGestionnaireId(Long gestionnaireId) {
		this.gestionnaireId = gestionnaireId;
	}
	public Long getAlertId() {
		return alertId;
	}
	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}
	
	
}
