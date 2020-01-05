package com.tasif.eventorganiserbe.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.eventorganiserbe.event.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	public List<Ticket> findByUserIdAndIsBooked(long userId, boolean isBooked);

}
