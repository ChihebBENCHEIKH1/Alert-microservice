package com.pfa.alertService.entities;

public class RequestOBjectOfaffectation {

		private Long idAlert;
		private Long idSuperviseur;
		public RequestOBjectOfaffectation() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RequestOBjectOfaffectation(Long idAlert, Long idSuperviseur) {
			super();
			this.idAlert = idAlert;
			this.idSuperviseur = idSuperviseur;
		}

		public Long getIdAlert() {
			return idAlert;
		}
		public void setIdAlert(Long idAlert) {
			this.idAlert = idAlert;
		}
		public Long getIdSuperviseur() {
			return idSuperviseur;
		}
		public void setIdSuperviseur(Long idSuperviseur) {
			this.idSuperviseur = idSuperviseur;
		}
		
}
