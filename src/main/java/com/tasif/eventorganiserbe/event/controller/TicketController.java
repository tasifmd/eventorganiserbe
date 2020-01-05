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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.eventorganiserbe.event.model.Ticket;
import com.tasif.eventorganiserbe.event.service.TicketService;
import com.tasif.eventorganiserbe.response.Response;
import com.tasif.eventorganiserbe.utility.JWTTokenHelper;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private JWTTokenHelper jwtTokenHelper;

	@PostMapping("/addtocart/{eventId}")
	public ResponseEntity<Response> addToCart(@RequestHeader String token, @PathVariable long eventId) {
		long userId = jwtTokenHelper.decodeToken(token);
		Response response = ticketService.addToCart(userId, eventId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Response> book(@RequestHeader String token, @RequestParam long ticketId) {
		long userId = jwtTokenHelper.decodeToken(token);
		Response response = ticketService.bookTicket(userId, ticketId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{ticketId}")
	public ResponseEntity<Response> cancel(@PathVariable long ticketId) {
		Response response = ticketService.cancelTicket(ticketId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/cart")
	public ResponseEntity<List<Ticket>> getCarts(@RequestHeader String token) {
		long userId = jwtTokenHelper.decodeToken(token);
		List<Ticket> responce = ticketService.getCart(userId);
		return new ResponseEntity<List<Ticket>>(responce,HttpStatus.OK);
	}
}
