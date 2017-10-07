package com.ticketbot.sales;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ticketbot.event.Event;

/**
 * <h1>Sale Entity Definition</h1>
 * 
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Entity
public class Sale {

	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private int numberOfTickets;
	private float totalPrice;
	
	@OneToOne
	private Event event;

	/**
	 * Default Constructor
	 * */
	public Sale() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param id				ID
	 * @param firstName			First Name
	 * @param lastName			Last Name
	 * @param email				Email
	 * @param numberOfTickets	Number Of Tickets Purchased
	 * @param totalPrice		Total Sale Price
	 * @param event				Event
	 * */
	public Sale(int id, String firstName, String lastName, String email, int numberOfTickets, float totalPrice,
			Event event) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numberOfTickets = numberOfTickets;
		this.totalPrice = totalPrice;
		this.event = event;
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
	 * Get First Name
	 * 
	 * @return <code>String</code>
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set First Name
	 * 
	 * @param firstName	First Name
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get Last Name
	 * 
	 * @return <code>String</code>
	 * */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set Last Name
	 * 
	 * @param lastName	Last Name
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get Email
	 * 
	 * @return <code>String</code>
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Set Email
	 * 
	 * @param email	Email
	 * */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get Number of Tickets
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	/**
	 * Set Number of Tickets
	 * 
	 * @param numberOfTickets	Number of Tickets Purchased
	 * */
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	
	/**
	 * Get Event
	 * 
	 * @return <code>Event</code>
	 * */
	public Event getEvent() {
		return event;
	}

	/**
	 * Set Event
	 * 
	 * @param event	Event
	 * */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Get Total Price
	 * 
	 * @return <code>Float</code>
	 * */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Set Total Price
	 * 
	 * @param totalPrice	Total Sale Price
	 * */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
