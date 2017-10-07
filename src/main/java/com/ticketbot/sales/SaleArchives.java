package com.ticketbot.sales;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ticketbot.event.EventArchive;

/**
 * <h1>Sale Archives Entity Definition</h1>
 * 
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Entity
public class SaleArchives {

	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private int numberOfTickets;
	private float totalPrice;
	
	@OneToOne
	private EventArchive eventArchive;

	/**
	 * Default Constructor
	 * */
	public SaleArchives() {
		super();
	}
	
	/**
	 * Constructor
	 * 
	 * @param sale			Sale
	 * @param eventArchive	Event Archive
	 * */
	public SaleArchives(Sale sale, EventArchive eventArchive) {
		super();
		this.firstName = sale.getFirstName();
		this.lastName = sale.getLastName();
		this.email = sale.getEmail();
		this.numberOfTickets = sale.getNumberOfTickets();
		this.totalPrice = sale.getTotalPrice();
		this.eventArchive = eventArchive;
	}
	
	/**
	 * Constructor
	 * 
	 * @param sale	Sale
	 * */
	public SaleArchives(Sale sale) {
		super();
		this.firstName = sale.getFirstName();
		this.lastName = sale.getLastName();
		this.email = sale.getEmail();
		this.numberOfTickets = sale.getNumberOfTickets();
		this.totalPrice = sale.getTotalPrice();
	}

	/**
	 * Constructor
	 * 
	 * @param id				Id
	 * @param firstName			First Name
	 * @param lastName			Last Name
	 * @param email				Email
	 * @param numberOfTickets	Number Of Tickets Purchase
	 * @param totalPrice		Total Sale Price
	 * @param eventArchive		Event Archive
	 * */
	public SaleArchives(int id, String firstName, String lastName, String email, int numberOfTickets, float totalPrice,
			EventArchive eventArchive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numberOfTickets = numberOfTickets;
		this.totalPrice = totalPrice;
		this.eventArchive = eventArchive;
	}

	/**
	 * Get Id
	 * 
	 * @return <code>Integer</code> id
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
	 * @return <code>EventArchive</code>
	 * */
	public EventArchive getEventArchive() {
		return eventArchive;
	}

	/**
	 * Set Event
	 * 
	 * @param eventArchive	Event Archive
	 * */
	public void setEventArchive(EventArchive eventArchive) {
		this.eventArchive = eventArchive;
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
