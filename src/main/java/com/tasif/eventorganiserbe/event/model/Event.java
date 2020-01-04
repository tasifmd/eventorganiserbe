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
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eventId;
	
	private String eventName;
	
	private String eventType;
	
	private String eventLocation;
	
	private String eventDate;
	
	private String ticketCost;
}
