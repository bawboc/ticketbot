package com.ticketbot.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ticketbot.members.Member;

/**
 * <h1>Event Archive Entity Definition</h1>
 * <p>
 * This defines the <code>EventArchive</code> entity.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Entity
public class EventArchive {
	
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
	public EventArchive() {
	}
	
	/**
	 * Constructor meant for adding new entities only.
	 * 
	 * @param id	Id
	 * */
	public EventArchive(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Constructor meant for adding new entities only.
	 * 
	 * @param event	Event
	 * */
	public EventArchive(Event event) {
		super();
		this.date = event.getDate();
		this.time = event.getTime();
		this.name = event.getName();
		this.location = event.getLocation();
		this.venue = event.getVenue();
		this.maxTickets = event.getMaxTickets();
		this.ticketsSold = event.getTicketsSold();
		this.ticketsAvailable = event.getTicketsAvailable();
		this.minimumTickets = event.getMinimumTickets();
		this.ticketPrice = event.getTicketPrice();
		this.description = event.getDescription();
	}
	
	/**
	 * Tickets Sold
	 * 
	 * @param tickets	Tickets Sold
	 * */
	public void ticketsSold(int tickets) {
		ticketsAvailable -= tickets;
		ticketsSold += tickets;
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
	 * @param maxTickets	Maximum Ticket Purchase
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
