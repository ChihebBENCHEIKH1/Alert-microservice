package com.pfa.alertService.entities;

import java.util.Date;

public class Alert_gestionnaire_followUp_info {
	    public Alert_gestionnaire_followUp_info() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Gestionnaire_alert getGestionnaire_alert() {
			return gestionnaire_alert;
		}
		public void setGestionnaire_alert(Gestionnaire_alert gestionnaire_alert) {
			this.gestionnaire_alert = gestionnaire_alert;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Alert_gestionnaire_followUp_info(Gestionnaire_alert gestionnaire_alert, String comment, Date date) {
			super();
			this.gestionnaire_alert = gestionnaire_alert;
			this.comment = comment;
			this.date = date;
		}
		private Gestionnaire_alert gestionnaire_alert;
	    private String comment;
	    private Date date;
	    // getters and setters
}
