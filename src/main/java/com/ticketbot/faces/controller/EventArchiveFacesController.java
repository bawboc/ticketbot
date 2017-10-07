package com.ticketbot.faces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.event.EventArchive;
import com.ticketbot.faces.repository.EventArchiveJPARepository;

import java.util.List;

/**
 * <h1>List Event Archives</h1>
 * <p>
 * This Controller accompanies the Event Archive List
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="eventarchivelist")
@ELBeanName(value="eventarchivelist")
@Join(path="/eventarchivelist", to="/event-archive-list.jsf")
public class EventArchiveFacesController {

	@Autowired
	private EventArchiveJPARepository eventArchiveRepository;
	
	private List<EventArchive> events;
	
	/**
	 * Initialize properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		events = eventArchiveRepository.findAll();
	}
	
	/**
	 * Get available Events
	 * 
	 * @return List of <code>Event</code>
	 * */
	public List<EventArchive> getEvents(){
		return events;
	}
	
	/**
	 * Get available Events
	 * <p>
	 *   A necessary duplicate
	 * </p>
	 * 
	 * @return List of <code>Event</code>
	 * */
	public List<EventArchive> getEvent(){
		return events;
	}
}
