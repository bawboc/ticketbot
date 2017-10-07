package com.ticketbot.faces.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbot.event.Event;

/**
 * <h1>Event JPA Repository</h1>
 * 
 * <p>Adds basic CRUD functionality</p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface EventJPARepository extends JpaRepository<Event, Integer> {

}
