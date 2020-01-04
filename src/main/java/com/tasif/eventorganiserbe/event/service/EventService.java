package com.tasif.eventorganiserbe.event.service;

import java.util.List;

import com.tasif.eventorganiserbe.event.dto.EventDto;
import com.tasif.eventorganiserbe.event.model.Event;
import com.tasif.eventorganiserbe.response.Response;

public interface EventService {
	
	public Response createEvent(EventDto eventDto);
	
	public Response updateEvent(long eventId, EventDto eventDto);
	
	public Response deleteEvent(long eventId);
	
	public List<Event> getAllEvents();

}
