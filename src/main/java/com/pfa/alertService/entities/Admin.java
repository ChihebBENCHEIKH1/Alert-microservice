package com.pfa.alertService.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
public class Admin extends User {

	public Admin(Long id, String email, String username) {
		super(id, email, username);
	}

}
