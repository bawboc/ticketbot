package com.ticketbot.faces.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.event.Event;
import com.ticketbot.faces.repository.EventJPARepository;

import java.util.List;

/**
 * <h1>Event List</h1>
 * <p>
 * This Controller accompanies the Event List
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="eventList")
@ELBeanName(value="eventList")
@Join(path="/eventlist", to="/event-list.jsf")
public class EventListFacesController {

	@Autowired
	private EventJPARepository eventRepository;
	
	private List<Event> events;
	
	/**
	 * Initialize Properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		events = eventRepository.findAll();
	}
	
	/**
	 * Get available Events
	 * 
	 * @return List of <code>Event</code>
	 * */
	public List<Event> getEvents(){
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
	public List<Event> getEvent(){
		return events;
	}
}
