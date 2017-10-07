package com.ticketbot.faces.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

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
import com.ticketbot.members.Member;

/**
 * <h1>New Event</h1>
 * <p>
 * This Controller accompanies the Add Event
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="eventFacesController")
@ELBeanName(value="eventFacesController")
@Join(path="/eventForm", to="/event-form.jsf")
public class EventFacesController {
	
	@Autowired
	private EventJPARepository eventRepository;
	
	@Autowired
	private ServletContext servletContext;
	
	private Event event = new Event();
	private Date date;
	private SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat tFormat = new SimpleDateFormat("HH:mm");
	
	
	private List<Member> members;
	private Member member;

	/**
	 * Initialize properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadDate() {
		member = (Member) servletContext.getAttribute("member");
	}
	
	/**
	 * Save Event and Redirect
	 * 
	 * @return redirect
	 * */
	public String save() {
		event.setEventOraganizer(member);
		eventRepository.save(event);
		event = new Event();
		return "/event-list.xhtml?faces-redirection=true";
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
	 * Get Members
	 * 
	 * @deprecated
	 * 
	 * @return members
	 * */
	public List<Member> getMembers() {
		return members;
	}
	
	/**
	 * Get Member
	 * 
	 * @deprecated
	 * 
	 * @return member
	 * */
	public Member getMember() {
		return member;
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
		event.setDate(dFormat.format(date));
		event.setTime(tFormat.format(date));
	}
	
}
