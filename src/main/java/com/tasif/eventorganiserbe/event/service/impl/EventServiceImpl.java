package com.tasif.eventorganiserbe.event.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.eventorganiserbe.event.dto.EventDto;
import com.tasif.eventorganiserbe.event.model.Event;
import com.tasif.eventorganiserbe.event.repository.EventRepository;
import com.tasif.eventorganiserbe.event.service.EventService;
import com.tasif.eventorganiserbe.response.Response;
import com.tasif.eventorganiserbe.utility.ResponseHelper;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EventRepository eventRepository;

	@Override
	public Response createEvent(EventDto eventDto) {
		Event event = modelMapper.map(eventDto, Event.class);
		eventRepository.save(event);
		Response response = ResponseHelper.statusInfo("Event created successfully", 1000);
		return response;
	}

	@Override
	public Response updateEvent(long eventId, EventDto eventDto) {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new RuntimeException("No event exist with eventId " + eventId));
		event.setEventName(eventDto.getEventName());
		event.setEventType(eventDto.getEventType());
		event.setEventLocation(eventDto.getEventLocation());
		event.setEventDate(eventDto.getEventDate());
		event.setTicketCost(eventDto.getTicketCost());
		Response response = ResponseHelper.statusInfo("Event updated successfully", 1000);
		return response;
	}

	@Override
	public Response deleteEvent(long eventId) {
		eventRepository.deleteById(eventId);
		Response response = ResponseHelper.statusInfo("Event deleted successfully", 1000);
		return response;
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = eventRepository.findAll();
		return events;
	}

}
