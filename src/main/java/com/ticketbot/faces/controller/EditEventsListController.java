package com.ticketbot.faces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ticketbot.admin.AdminRepository;
import com.ticketbot.event.Event;
import com.ticketbot.event.EventRepository;
import com.ticketbot.members.Member;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * <h1>Edit <code>Event</code>s.</h1>
 * <p>
 * This Controller accompanies the Edit Event
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@ViewScoped
@Component(value="editevents")
@ELBeanName(value="editevents")
@Join(path="/editevents", to="/edit-list.jsf")
public class EditEventsListController implements Serializable {

	private static final long serialVersionUID = -718555757298616188L;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ServletContext servletContext;
	
	private List<Event> events;
	private Member member;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private Date date;
	private SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat tFormat = new SimpleDateFormat("HH:mm");
	
	/**
	 * <h1>Initialize Properties</h1>
	 * 
	 * <p>
	 *   Generates List of editable <code>Event</code> base on
	 *   whether user is a <code>Member</code> organizer or an
	 *   <code>Admin</code>.
	 * </p>
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		
		member = (Member) servletContext.getAttribute("member");
		if	((adminRepository.findByEmail(member.getEmail()))!=null) {
			// All events
			events = (List<Event>) eventRepository.findAll();
		} else {
			// events for this member
			events = (List<Event>) eventRepository.findByEventOraganizer(member);
		}
		
	}
	
	/**
	 * Converts date
	 * 
	 * @param event	Event
	 * 
	 * @return <code>Date</code>
	 * */
	public Date dateConverter(Event event) {
		try {
			return format.parse(String.format("%s %s", event.getDate(),event.getTime()));
		} catch (ParseException e) {}
		return null;
	}
	
	/**
	 * Set Date
	 * 
	 * @param event	Event
	 * */
	public void setDate(Event event) {
		event.setDate(dFormat.format(date));
		event.setTime(tFormat.format(date));
	}
	
	/**
	 * @param event	Event
	 * 
	 * @deprecated
	 * */
	public void onRowEdit(RowEditEvent event) {
		Event e = (Event) event.getObject();
		e.setDate(dFormat.format(date));
		e.setTime(tFormat.format(date));
		eventRepository.save(e);
		FacesMessage msg = new FacesMessage("Event edited", ((Event) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	/**
	 *  @param event	Event
	 * 
	 * @deprecated
	 * */
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Event) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	/**
	 * Save Changes and Redirect
	 * 
	 * @return redirect
	 * */
	public String save() {
		events.forEach(eventRepository::save);
		return "/event-list.xhtml?faces-redirection=true";
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

	/**
	 * Get Date
	 * 
	 * @return <code>Date</code>
	 * */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Set Date
	 * 
	 * @param date	Date
	 * */
	public void setDate(Date date) {
		this.date = date;
	}
	
}
