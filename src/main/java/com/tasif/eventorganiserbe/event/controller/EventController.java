package com.tasif.eventorganiserbe.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.eventorganiserbe.event.dto.EventDto;
import com.tasif.eventorganiserbe.event.model.Event;
import com.tasif.eventorganiserbe.event.service.EventService;
import com.tasif.eventorganiserbe.response.Response;

@RestController
@RequestMapping("/event")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping
	public ResponseEntity<Response> createEvent(@RequestBody EventDto eventDto) {
		Response response = eventService.createEvent(eventDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<Response> updateEvent(@PathVariable long eventId, @RequestBody EventDto eventDto) {
		Response response = eventService.updateEvent(eventId, eventDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity<Response> deleteEvent(@PathVariable long eventId) {
		Response response = eventService.deleteEvent(eventId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Event>> getEvents() {
		List<Event> response = eventService.getAllEvents();
		return new ResponseEntity<List<Event>>(response, HttpStatus.OK);
	}
}
