package com.pfa.alertService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Attachement {
	@Override
	public String toString() {
		return "Attachement [id=" + id + ", title=" + title + ", description=" + description + ", alert=" + alert
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getAlert()=" + getAlert() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Alert getAlert() {
		return alert;
	}
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	public Attachement(Long id, String title, String description, Alert alert) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.alert = alert;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String type;
	public Attachement(Long id, String title, String description, String type, byte[] fileData, Alert alert) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.fileData = fileData;
		this.alert = alert;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Lob
	@Column(name = "file_size")
	private byte[] fileData;
	@ManyToOne(cascade = CascadeType.ALL)
	private Alert alert;
	public Attachement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
