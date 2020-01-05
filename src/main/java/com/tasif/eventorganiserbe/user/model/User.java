package com.tasif.eventorganiserbe.user.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tasif.eventorganiserbe.event.model.Ticket;

import lombok.Data;

@Entity
@Table
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String userName;
	private String userEmail;
	private String password;
	@ManyToMany
	private List<Ticket> cart;
}
