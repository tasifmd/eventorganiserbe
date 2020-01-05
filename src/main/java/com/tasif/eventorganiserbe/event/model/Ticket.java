package com.tasif.eventorganiserbe.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ticketId;

	private long eventId;

	private String eventName;

	private String eventDate;
	
	private String price;

	private long userId;

	private boolean isBooked;
}
