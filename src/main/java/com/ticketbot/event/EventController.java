package com.ticketbot.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbot.members.Member;

/**
 * <h1>Event Controller Definition</h1>
 * <p>
 * This provides REST functionality for the <code>Event</code> database.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@CrossOrigin
@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	/**
	 * Get All <code>Event</code> Rows in Database.
	 * 
	 * @return List of All <code>Event</code>.
	 * */
	@RequestMapping("/events")
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	
	/**
	 * Get Single <code>Event</code> from Database.
	 * 
	 * Uses Path Variable
	 * 
	 * @param eventId Event Id
	 * 
	 * @return <code>Event</code>
	 * */
	@RequestMapping("/events/eventbyid/{eventId}")
	public Event getEventById(@PathVariable int eventId) {
		return eventService.getEventById(eventId);
	}
	
	/**
	 * Get Single <code>Event</code> from Database.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Event</code>
	 * */
	@RequestMapping("/events/id")
	public Event getById(@RequestParam int id) {
		return eventService.getEventById(id);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name.
	 * 
	 * Uses Path Variable
	 * 
	 * @param name	Name
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyname/{name}")
	public List<Event> getEventsByName(@PathVariable String name){
		return eventService.getEventsByName(name);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param name	Name
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/name")
	public List<Event> geByName(@RequestParam String name){
		return eventService.getEventsByName(name);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Date.
	 * 
	 * Uses Path Variable
	 * 
	 * @param date	Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbydate/{date}")
	public List<Event> getEventsByDate(@PathVariable String date){
		return eventService.getEventsByDate(date);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Date.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param date	Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/date")
	public List<Event> getByDate(@RequestParam String date){
		return eventService.getEventsByDate(date);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Location.
	 * 
	 * Uses Path Variable
	 * 
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbylocation/{location}")
	public List<Event> getEventsByLocation(@PathVariable String location){
		return eventService.getEventsByLocation(location);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Location.
	 * 
	 * Uses Request Parameter
	 *
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/location")
	public List<Event> getByLocation(@RequestParam String location){
		return eventService.getEventsByLocation(location);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Venue.
	 * 
	 * Uses Path Variable
	 * 
	 * @param venue	Venue
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyvenue/{venue}")
	public List<Event> getEventsByVenue(@PathVariable String venue){
		return eventService.getEventsByVenue(venue);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Venue.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param venue	Venue
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/venue")
	public List<Event> getByVenue(@RequestParam String venue){
		return eventService.getEventsByVenue(venue);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Time.
	 * 
	 * Uses Path Variable
	 * 
	 * @param time	Time
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbytime/{time}")
	public List<Event> getEventsByTime(@PathVariable String time){
		return eventService.getEventsByTime(time);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Time.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param time	Time
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/time")
	public List<Event> getByTime(@RequestParam String time){
		return eventService.getEventsByTime(time);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Max Tickets.
	 * 
	 * Uses Path Variable
	 * 
	 * @param maxTickets	Maximum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbymaxtickets/{maxTickets}")
	public List<Event> getEventsByMaxTickets(@PathVariable int maxTickets){
		return eventService.getEventsByMaxTickets(maxTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Max Tickets.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param maxTickets	Maximum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/maxtickets")
	public List<Event> getByMaxTickets(@RequestParam int maxTickets){
		return eventService.getEventsByMaxTickets(maxTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Sold.
	 * 
	 * Uses Path Variable
	 * 
	 * @param ticketsSold	Tickets Sold
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyticketssold/{ticketsSold}")
	public List<Event> getEventsByTicketsSold(@PathVariable int ticketsSold){
		return eventService.getEventsByTicketsSold(ticketsSold);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Sold.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param ticketsSold	Tickets Sold
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/ticketssold")
	public List<Event> getByTicketsSold(@RequestParam int ticketsSold){
		return eventService.getEventsByTicketsSold(ticketsSold);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Available.
	 * 
	 * Uses Path Variable
	 * 
	 * @param ticketsAvailable	Tickets Available
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyticketsavailable/{ticketsAvailable}")
	public List<Event> getEventsByTicketsAvailable(@PathVariable int ticketsAvailable){
		return eventService.getEventsByTicketsAvailable(ticketsAvailable);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Available.
	 * 
	 * Uses Request Variable
	 * 
	 * @param ticketsAvailable	Tickets Available
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/ticketsavailable")
	public List<Event> getByTicketsAvailable(@RequestParam int ticketsAvailable){
		return eventService.getEventsByTicketsAvailable(ticketsAvailable);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Minimum Tickets.
	 * 
	 * Uses Path Variable
	 * 
	 * @param minimumTickets	Minimum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyminimumtickets/{minimumTickets}")
	public List<Event> getEventsByMinimumTickets(@PathVariable int minimumTickets){
		return eventService.getEventsByMinimumTickets(minimumTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Minimum Tickets.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param minimumTickets	Minimum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/minimumtickets")
	public List<Event> getByMinimumTickets(@RequestParam int minimumTickets){
		return eventService.getEventsByMinimumTickets(minimumTickets);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Price.
	 * 
	 * Uses Path Variable
	 * 
	 * @param ticketPrice	Ticket Price
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/eventbyticketprice/{ticketPrice:.+}")
	public List<Event> getEventsByTicketPrice(@PathVariable float ticketPrice){
		return eventService.getEventsByTicketPrice(ticketPrice);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Price.
	 * 
	 * Uses Request Parameter
	 * 
	 * @param ticketPrice	Ticket Price
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/ticketprice")
	public List<Event> getByTicketPrice(@RequestParam float ticketPrice){
		return eventService.getEventsByTicketPrice(ticketPrice);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name and Location.
	 * 
	 * Uses Named Query and Request Parameters
	 * 
	 * @param name	Name
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/nameAndLocation")
	public List<Event> getByNameAndLocation(@RequestParam String name, @RequestParam String location){
		return eventService.getEventsByLocationAndName(name, location);
	}
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name, Location and Date.
	 * 
	 * Uses Named Query and Request Parameters
	 * 
	 * @param name	Name
	 * @param location	Location
	 * @param date	Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	@RequestMapping("/events/nameLocationDate")
	public List<Event> getByNameAndLocationAndDate(@RequestParam String name, @RequestParam String location, @RequestParam String date){
		return eventService.getEventsByLocationNameDate(name, location, date);
	}
	
	/**
	 * Add an <code>Event</code>
	 * 
	 * @param event	Event
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/events")
	public void addEvent(@RequestBody Event event) {
		eventService.addEvent(event);
	}
	
	/**
	 * Add an <code>Event</code>
	 * 
	 * @param date				Date
	 * @param time				Time
	 * @param name				Name
	 * @param location			Location	
	 * @param venue				Venue
	 * @param organizer			Organizer
	 * @param maxTickets		Max Ticket Purchase
	 * @param ticketsSold		Tickets Sold
	 * @param ticketsAvailable	Tickets Available
	 * @param minimumTickets	Minimum Ticket Purchase
	 * @param ticketPrice		Ticket Price
	 * @param description		Description
	 * 
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/events/new")
	public void addNewEvent(@RequestParam String date, @RequestParam String time, @RequestParam String name, @RequestParam String location,
			@RequestParam String venue, @RequestParam int organizer, @RequestParam int maxTickets,
			@RequestParam int ticketsSold, @RequestParam int ticketsAvailable, @RequestParam int minimumTickets, @RequestParam float ticketPrice,
			@RequestParam String description) {
		Event event = new Event();
		event.setEventOraganizer(new Member(organizer));
		event.setDate(date);
		event.setDescription(description);
		event.setLocation(location);
		event.setMaxTickets(maxTickets);
		event.setMinimumTickets(minimumTickets);
		event.setVenue(venue);
		event.setName(name);
		event.setTicketPrice(ticketPrice);
		event.setTicketsSold(ticketsSold);
		event.setTicketsAvailable(ticketsAvailable);
		event.setTicketsSold(ticketsSold);
		event.setTime(time);
		eventService.addEvent(event);
	}
	
	/**
	 * Update an <code>Event</code>
	 * 
	 * @param event	Event
	 * */
	@RequestMapping(method=RequestMethod.PUT, value="/events")
	public void updateEvent(@RequestBody Event event) {
		eventService.updateEvent(event);
	}
	
	/**
	 * Update an <code>Event</code>
	 * 
	 * @param eventID				Event Id
	 * @param date					Date
	 * @param time					Time
	 * @param name					Name	
	 * @param location				Location
	 * @param venue					Venue
	 * @param organizer				Organizer
	 * @param maxTickets			Max Ticket Purchase
	 * @param ticketsSold			Tickets Sold
	 * @param ticketsAvailable		Tickets Available
	 * @param minimumTickets		Minimum Ticket Purchase
	 * @param ticketPrice			Ticket Price
	 * @param description			Description
	 * 
	 * */
	@RequestMapping(method=RequestMethod.PUT, value="/events/change")
	public void changeEvent(@RequestParam int eventID, @RequestParam String date, @RequestParam String time, @RequestParam String name, @RequestParam String location,
			@RequestParam String venue, @RequestParam int organizer, @RequestParam int maxTickets,
			@RequestParam int ticketsSold, @RequestParam int ticketsAvailable, @RequestParam int minimumTickets, @RequestParam float ticketPrice,
			@RequestParam String description) {
		Event event = new Event(eventID);
		event.setEventOraganizer(new Member(organizer));
		event.setDate(date);
		event.setDescription(description);
		event.setLocation(location);
		event.setMaxTickets(maxTickets);
		event.setMinimumTickets(minimumTickets);
		event.setVenue(venue);
		event.setName(name);
		event.setTicketPrice(ticketPrice);
		event.setTicketsSold(ticketsSold);
		event.setTicketsAvailable(ticketsAvailable);
		event.setTicketsSold(ticketsSold);
		event.setTime(time);
		eventService.updateEvent(event);
	}
	
	/**
	 * Delete an <code>Event</code>
	 * 
	 * @param id	Id
	 * 
	 * */
	@RequestMapping(method=RequestMethod.DELETE, value="/events/{id}")
	public void deleteEvent(@PathVariable int id) {
		eventService.deleteEvent(id);
	}
}
