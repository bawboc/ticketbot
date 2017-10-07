package com.ticketbot.faces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbot.event.EventArchive;

/**
 * <h1>Event Archive JPA Repository</h1>
 * 
 * <p>Adds basic CRUD functionality</p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface EventArchiveJPARepository extends JpaRepository<EventArchive, Integer> {

}
