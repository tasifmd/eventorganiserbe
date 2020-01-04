package com.tasif.eventorganiserbe.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.eventorganiserbe.event.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
