package com.pfa.alertService.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pfa.alertService.entities.Attachement;
import com.pfa.alertService.entities.FollowUp;
import com.pfa.alertService.entities.Gestionnaire;

public class AlertDto {
		public AlertDto() {
			// TODO Auto-generated constructor s
			super();
			// TODO Auto-generated constructor stub
		}
		private Long id;
		private String code;
		private Date creationDate;
		private String type;
		private String status;
		private String description;
		public AlertDto(Long id, String code, Date creationDate, String type, String status, String description) {
			super();
			this.id = id;
			this.code = code;
			this.creationDate = creationDate;
			this.type = type;
			this.status = status;
			this.description = description;
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
		
		
		

	}
