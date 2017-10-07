package com.ticketbot.event;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Event Service Definition</h1>
 * <p>
 * This provides functionality to for communication between the 
 * <code>EventRepository</code> and the <code>EventController</code>.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	/**
	 * Get All <code>Event</code> Rows in Database.
	 * 
	 * @return List of All <code>Event</code>.
	 * */
	public List<Event> getAllEvents(){
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(events::add);
		return events;
	}
	
	/**
	 * Get Single <code>Event</code> from Database.
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Event</code>
	 * */
	public Event getEventById(int id) {
		return eventRepository.findOne(id);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name.
	 * 
	 * @param name	Name
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByName(String name) {
		return eventRepository.findByName(name);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Location.
	 * 
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByLocation(String location){
		return eventRepository.findByLocation(location);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Date.
	 * 
	 * @param date	Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByDate(String date){
		return eventRepository.findByDate(date);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Venue.
	 * 
	 * @param venue	Venue
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByVenue(String venue){
		return eventRepository.findByVenue(venue);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Time.
	 * 
	 * @param time	Time
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByTime(String time){
		return eventRepository.findByTime(time);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Max Tickets.
	 * 
	 * @param maxTickets	Max Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByMaxTickets(int maxTickets){
		return eventRepository.findByMaxTickets(maxTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Sold.
	 * 
	 * @param ticketsSold	Tickets Sold
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByTicketsSold(int ticketsSold){
		return eventRepository.findByTicketsSold(ticketsSold);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Available.
	 * 
	 * @param ticketsAvaiable	Tickets Available
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByTicketsAvailable(int ticketsAvaiable){
		return eventRepository.findByTicketsAvailable(ticketsAvaiable);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Minimum Tickets.
	 * 
	 * @param minimumTickets	Minimum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByMinimumTickets(int minimumTickets){
		return eventRepository.findByMinimumTickets(minimumTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Price.
	 * 
	 * @param ticketPrice	Ticket Price
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByTicketPrice(float ticketPrice){
		return eventRepository.findByTicketPrice(ticketPrice);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name and Location.
	 * 
	 * Uses Named Query
	 * 
	 * @param name		Name
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByLocationAndName(String name, String location){
		return eventRepository.locationAndName(name, location);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name, Location and Date.
	 * 
	 * Uses Named Query
	 * 
	 * @param name		Name
	 * @param location	Location
	 * @param date		Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> getEventsByLocationNameDate(String name, String location, String date){
		return eventRepository.locationNameDate(name, location, date);
	}
	
	/**
	 * Add an <code>Event</code>
	 * 
	 * @param event	Event
	 * */
	public void addEvent(Event event) {
		eventRepository.save(event);
	}
	
	/**
	 * Update an <code>Event</code>
	 * 
	 * @param event	Event
	 * */
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	
	/**
	 * Delete an <code>Event</code>
	 * 
	 * @param id	Id
	 * */
	public void deleteEvent(int id) {
		eventRepository.delete(id);
	}
}
