package com.tasif.eventorganiserbe.event.service;

import java.util.List;

import com.tasif.eventorganiserbe.event.model.Ticket;
import com.tasif.eventorganiserbe.response.Response;

public interface TicketService {

	public Response bookTicket(long userId, long ticketId);

	public Response cancelTicket(long ticketId);

	public Response addToCart(long userId, long eventId);

	public List<Ticket> getCart(long userId);
}
