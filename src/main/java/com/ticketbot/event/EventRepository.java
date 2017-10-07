package com.ticketbot.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ticketbot.members.Member;
/**
 * <h1>Event Repository Definition</h1>
 * <p>
 * This provides functionality to for communication between the 
 * <code>Event</code> database and the <code>EventService</code>.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Name.
	 * 
	 * @param name	Name
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByName(String name);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Date.
	 * 
	 * @param date	Date
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByDate(String date);
	

	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Location.
	 * 
	 * @param location	Location
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByLocation(String location);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Venue.
	 * 
	 * @param venue	Venue
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByVenue(String venue);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Time.
	 * 
	 * @param time	Time
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByTime(String time);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Max Tickets.
	 * 
	 * @param maxTickets	Max Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByMaxTickets(int maxTickets);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Sold.
	 * 
	 * @param ticketsSold	Tickets Sold
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByTicketsSold(int ticketsSold);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Available.
	 * 
	 * @param ticketsAvailable	Tickets Available
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByTicketsAvailable(int ticketsAvailable);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Minimum Tickets.
	 * 
	 * @param minimumTickets	Minimum Ticket Purchase
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByMinimumTickets(int minimumTickets);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Tickets Price.
	 * 
	 * @param ticketPrice	Ticket Price
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByTicketPrice(float ticketPrice);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same Description.
	 * 
	 * @param description	Description
	 * 
	 * @return List of <code>Event</code>.
	 * 
	 * @deprecated
	 * */
	public List<Event> findByDescription(String description);
	
	/**
	 * Get All <code>Event</code> Rows in Database
	 * with same <code>Member</code> Organizer.
	 * 
	 * @param member	Member Organizer
	 * 
	 * @return List of <code>Event</code>.
	 * */
	public List<Event> findByEventOraganizer(Member member);
	
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
	public List<Event> locationAndName(@Param("name") String name, @Param("location") String location);
	
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
	public List<Event> locationNameDate(@Param("name") String name, @Param("location") String location, @Param("date") String date);
}
