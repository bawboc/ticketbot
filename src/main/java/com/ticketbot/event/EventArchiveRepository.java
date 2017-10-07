package com.ticketbot.event;

import org.springframework.data.repository.CrudRepository;

/**
 * <h1>Event Archive Repository Definition</h1>
 * <p>
 * This provides functionality to for communication with the 
 * <code>EventArchive</code> database.
 * </p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface EventArchiveRepository extends CrudRepository<EventArchive, Integer> {

}
