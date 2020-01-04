package com.tasif.eventorganiserbe.event.dto;

import lombok.Data;

@Data
public class EventDto {
	
	private String eventName;

	private String eventType;

	private String eventLocation;

	private String eventDate;

	private String ticketCost;
}
