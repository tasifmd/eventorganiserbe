package com.tasif.eventorganiserbe.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.eventorganiserbe.event.model.Event;
import com.tasif.eventorganiserbe.event.model.Ticket;
import com.tasif.eventorganiserbe.event.repository.EventRepository;
import com.tasif.eventorganiserbe.event.repository.TicketRepository;
import com.tasif.eventorganiserbe.event.service.TicketService;
import com.tasif.eventorganiserbe.response.Response;
import com.tasif.eventorganiserbe.user.model.User;
import com.tasif.eventorganiserbe.user.repository.UserRepository;
import com.tasif.eventorganiserbe.utility.ResponseHelper;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public Response bookTicket(long userId, long ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		ticket.setBooked(true);
		ticketRepository.save(ticket);
		Response response = ResponseHelper.statusInfo("Ticket booked successfully", 1000);
		return response;
	}

	@Override
	public Response cancelTicket(long ticketId) {
		ticketRepository.deleteById(ticketId);
		Response response = ResponseHelper.statusInfo("Ticket cancel successfully", 1000);
		return response;
	}

	@Override
	public Response addToCart(long userId, long eventId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with userId " + userId));
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new RuntimeException("No event exist with eventId " + eventId));
		Ticket ticket = new Ticket();
		ticket.setUserId(userId);
		ticket.setEventId(eventId);
		ticket.setEventName(event.getEventName());
		ticket.setEventDate(event.getEventDate());
		ticket.setPrice(event.getTicketCost());
		user.getCart().add(ticket);
		ticketRepository.save(ticket);
		userRepository.save(user);
		Response response = ResponseHelper.statusInfo("Ticket added to cart successfully", 1000);
		return response;
	}

	@Override
	public List<Ticket> getCart(long userId) {
		return ticketRepository.findByUserIdAndIsBooked(userId, false);
	}

}
