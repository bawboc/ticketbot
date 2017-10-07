package com.ticketbot.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.ticketbot.members.Member;

/**
 * <h1>Event Entity Definition</h1>
 * <p>
 * This defines the <code>Event</code> entity and
 * provides named queries. 
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Entity
@NamedQueries({
	@NamedQuery(name="Event.locationAndName",
			query="SELECT e from Event e WHERE LOWER(e.name) = LOWER(:name) AND LOWER(e.location) = LOWER(:location)"),
	@NamedQuery(name="Event.locationNameDate",
	query="SELECT e from Event e WHERE LOWER(e.name) = LOWER(:name) AND LOWER(e.location) = LOWER(:location) AND LOWER(e.date) = LOWER(:date)")
})
public class Event {
	
	
	@Id
	@GeneratedValue
	private int id;
	
	private String date;
	private String time;
	
	private String name;
	private String location;
	private String venue;
	
	@OneToOne
	private Member eventOraganizer;
	
	private int maxTickets;
	private int ticketsSold;
	private int ticketsAvailable;
	private int minimumTickets;
	private float ticketPrice;
	
	private String description;
	
	/**
	 * Default Constructor
	 * */
	public Event() {
	}
	
	/**
	 * Constructor meant for adding new entities only.
	 * 
	 * @param id Id
	 * */
	public Event(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Event creation without <code>Member</code>
	 * 
	 * @param id 				Id
	 * @param date 				Date
	 * @param time 				Time
	 * @param name 				Name
	 * @param location 			Location
	 * @param venue 			Venue
	 * @param maxTickets 		Maximum Tickets
	 * @param ticketsSold 		Tickets Sold
	 * @param ticketsAvailable	Tickets Available
	 * @param minimumTickets	Minimum Ticket Purchase
	 * @param ticketPrice		Ticket Price
	 * @param description		Description
	 * */
	public Event(int id, String date, String time, String name, String location, String venue, int maxTickets,
			int ticketsSold, int ticketsAvailable, int minimumTickets, float ticketPrice, String description) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.name = name;
		this.location = location;
		this.venue = venue;
		this.maxTickets = maxTickets;
		this.ticketsSold = ticketsSold;
		this.ticketsAvailable = ticketsAvailable;
		this.minimumTickets = minimumTickets;
		this.ticketPrice = ticketPrice;
		this.description = description;
	}
	
	/**
	 * Adjusts tickets available and tickets
	 * sold from a transaction.
	 * 
	 * @param tickets	Number of Tickets Sold
	 * */
	public void ticketsSold(int tickets) {
		ticketsAvailable -= tickets;
		ticketsSold += tickets;
	}
	

	/**
	 * Event creation including <code>Member</code>
	 * 
	 * @param id				ID
	 * @param date				Date
	 * @param time				Time
	 * @param name				Name	
	 * @param location			Location
	 * @param venue				Venue
	 * @param eventOraganizer	Event Organizer
	 * @param maxTickets		Maximum Tickets
	 * @param ticketsSold		Tickets Sold
	 * @param ticketsAvailable	Tickets Available
	 * @param minimumTickets	Minimum Ticket Purchase
	 * @param ticketPrice		Ticket Price
	 * @param description		Description
	 * */
	public Event(int id, String date, String time, String name, String location, String venue,
			Member eventOraganizer, int maxTickets, int ticketsSold, int ticketsAvailable, int minimumTickets,
			float ticketPrice, String description) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.name = name;
		this.location = location;
		this.venue = venue;
		this.eventOraganizer = eventOraganizer;
		this.maxTickets = maxTickets;
		this.ticketsSold = ticketsSold;
		this.ticketsAvailable = ticketsAvailable;
		this.minimumTickets = minimumTickets;
		this.ticketPrice = ticketPrice;
		this.description = description;
	}

	/**
	 * Get <code>Member</code> Organizer
	 * 
	 * @return <code>Member</code>
	 * */
	public Member getEventOraganizer() {
		return eventOraganizer;
	}

	/**
	 * Set <code>Member</code> Organizer
	 * @param eventOraganizer	Event Organizer
	 * */
	public void setEventOraganizer(Member eventOraganizer) {
		this.eventOraganizer = eventOraganizer;
	}

	/**
	 * Get Time
	 * 
	 * @return <code>String</code>
	 * */
	public String getTime() {
		return time;
	}

	/**
	 * Set Time
	 * 
	 * @param time	Time
	 * */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Get Venue
	 * 
	 * @return <code>String</code>
	 * */
	public String getVenue() {
		return venue;
	}

	/**
	 * Set Venue.
	 * 
	 * @param venue	Venue
	 * */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * Get Max Tickets
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getMaxTickets() {
		return maxTickets;
	}

	/**
	 * Set Max Tickets
	 * 
	 * @param maxTickets	Maximum Tickets
	 * */
	public void setMaxTickets(int maxTickets) {
		this.maxTickets = maxTickets;
	}

	/**
	 * Get Tickets Sold
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getTicketsSold() {
		return ticketsSold;
	}

	/**
	 * Set Tickets Sold
	 * 
	 * @param ticketsSold	Tickets Sold
	 * */
	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	/**
	 * Get Tickets Available
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getTicketsAvailable() {
		return ticketsAvailable;
	}

	/**
	 * Set Tickets Available
	 * 
	 * @param ticketsAvailable	Tickets Available
	 * */
	public void setTicketsAvailable(int ticketsAvailable) {
		this.ticketsAvailable = ticketsAvailable;
	}

	/**
	 * Get Minimum Tickets
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getMinimumTickets() {
		return minimumTickets;
	}

	/**
	 * Set Minimum Tickets
	 * 
	 * @param minimumTickets	Minimum Ticket Purchase
	 * */
	public void setMinimumTickets(int minimumTickets) {
		this.minimumTickets = minimumTickets;
	}

	/**
	 * Get Ticket Price
	 * 
	 * @return <code>Float</code>
	 * */
	public float getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * Set Ticket Price
	 * 
	 * @param ticketPrice	Ticket Price
	 * */
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	/**
	 * Get Id
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getId() {
		return id;
	}

	/**
	 * Set Id
	 * 
	 * @param id	Id
	 * */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get Name
	 * 
	 * @return <code>String</code>
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Set Name
	 * 
	 * @param name	Name
	 * */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get Description
	 * 
	 * @return <code>String</code>
	 * */
	public String getDescription() {
		return description;
	}

	/**
	 * Set Description
	 * 
	 * @param description	Description
	 * */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get Date
	 * 
	 * @return <code>String</code>
	 * */
	public String getDate() {
		return date;
	}

	/**
	 * Set Date
	 * 
	 * @param date	Date
	 * */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get Location
	 * 
	 * @return <code>String</code>
	 * */
	public String getLocation() {
		return location;
	}

	/**
	 * Set Location
	 * 
	 * @param location	Location
	 * */
	public void setLocation(String location) {
		this.location = location;
	}

}
