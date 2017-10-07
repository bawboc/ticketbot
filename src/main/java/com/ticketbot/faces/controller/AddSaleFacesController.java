package com.ticketbot.faces.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ticketbot.event.Event;
import com.ticketbot.faces.repository.EventJPARepository;
import com.ticketbot.faces.repository.SaleJPARepository;
import com.ticketbot.members.Member;
import com.ticketbot.sales.Sale;
import com.ticketbot.emails.EmailResponse;

/**
 * <h1>Add a New Sale</h1>
 * <p>
 * This Controller accompanies the New Sale
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="addSaleFacesController")
@ELBeanName(value="addSaleFacesController")
@Join(path="/saleForm", to="/sale-form.jsf")
public class AddSaleFacesController {

	@Autowired
	private SaleJPARepository saleRepository;
	
	@Autowired
	private EventJPARepository eventRepository;
	
	@Autowired
	private EmailResponse emailResponse;
	
	@Autowired
	private ServletContext servletContext;
	
	private Sale sale = new Sale();
	private Event event;
	private Member member;
	
	private List<Event> events;
	private int eventId;
	private Map<String, Integer> eventMap;
	
	/**
	 * Initializes Required Properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		events = eventRepository.findAll();
		eventMap = new LinkedHashMap<>();
		events.forEach(e->eventMap.put(e.getName(), e.getId()));
		event = events.get(0);
		member = (Member) servletContext.getAttribute("member");
	}
	
	/**
	 * The saves the newly created <code>Sale</code>
	 * Updates <code>Event</code>
	 * Sends email response.
	 * 
	 * @return redirect
	 * */
	public String save() {
		sale.setEvent(new Event(eventId));
		sale.setEmail(member.getEmail());
		sale.setFirstName(member.getFirstName());
		sale.setLastName(member.getLastName());
		event = eventRepository.findOne(eventId);
		if (event.getTicketsAvailable() >= this.sale.getNumberOfTickets() && event.getMaxTickets() >= this.sale.getNumberOfTickets()) {
			this.sale.setTotalPrice(event.getTicketPrice() * this.sale.getNumberOfTickets());
			event.ticketsSold(this.sale.getNumberOfTickets());
			eventRepository.save(event);
			saleRepository.save(sale);
			emailResponse.ticketSaleResponse(sale,event);
		}else {
			sale = new Sale();
			return "/sale-list.xhtml?faces-redirection=true";
		}
		
		sale = new Sale();
		return "/sale-list.xhtml?faces-redirection=true";
	}

	/**
	 * Generates <code>Map</code> for <code>Event</code> choices.
	 * 
	 * @param eventMap Map Of Events
	 * */
	public void setEventMap(Map<String, Integer> eventMap) {
		this.eventMap = eventMap;
	}

	/**
	 * Get Sale
	 * 
	 * @return <code>Sale</code>
	 * */
	public Sale getSale() {
		return sale;
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
	 * Get Events
	 * 
	 * @return List of <code>Event</code>
	 * */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Get Event Id
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Set Event Id
	 * 
	 * @param eventId Event Id
	 * */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * Get Event Map
	 * <p>
	 *   Used for Drop Down Menu
	 * </p>
	 * 
	 * @return <code>Map</code> of <code>Event</code> 
	 * */
	public Map<String, Integer> getEventMap() {
		return eventMap;
	}
}