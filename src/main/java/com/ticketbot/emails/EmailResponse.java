package com.ticketbot.emails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ticketbot.admin.AdminRepository;
import com.ticketbot.event.Event;
import com.ticketbot.members.Member;
import com.ticketbot.sales.Sale;

/**
 * <h1>Email Response Definition</h1>
 * <p>
 * This provides generic email responses. 
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class EmailResponse {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private AdminRepository adminRepository;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat response = new SimpleDateFormat("EEEE, MMMM d, yyyy");
	private Date date;

	/**
	 * Response for Ticket Sale
	 * 
	 * @param sale Sale
	 * @param event Event
	 * 
	 * */
	public void ticketSaleResponse(Sale sale, Event event) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			try {
				date = format.parse(event.getDate());
			} catch (ParseException e) {
			}
			helper.setTo(sale.getEmail());
			helper.setText(String
					.format("Thank you, %s %s for your purchase!\n"
					+ "You have purchased %d ticket(s) at $%.2f for %s.\n"
					+ "We look forward to seeing you at %s on %s at %s.", 
					sale.getFirstName(),sale.getLastName(),
					sale.getNumberOfTickets(),sale.getTotalPrice(),event.getName(),
					event.getVenue(), response.format(date), event.getTime()));
			helper.setSubject("Ticket Purchase");
			sender.send(message);
		} catch (MessagingException e) {}
		
	}
	
	/**
	 * Response for Admin Request
	 * 
	 * @param member Member
	 * 
	 * */
	public void addAdminResponse(Member member) {
		String email = member.getEmail().replaceAll("@", "%40");
		String first = member.getFirstName();
		String last = member.getLastName();
		String text = String.format("New admin request from %s %s\nto authorize, use link:\n"
						+ "http://ticketbotai.azurewebsites.net/admin/add?email=%s",first,last,email);
		
		adminRepository.findAll().forEach(admin->{
			try {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message,true);
				helper.setTo(admin.getEmail());
				helper.setText(text);
				helper.setSubject("Admin Request");
				sender.send(message);
			} catch (MessagingException e) {}
		});
		
	}
	
	/**
	 * Response for Admin Approval
	 * 
	 * @param email Email
	 * 
	 * */
	public void grantedAdminResponse(String email) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(email);
			helper.setText("You have been granted administrative access.");
			helper.setSubject("Admin Granted");
			sender.send(message);
		} catch (MessagingException e) {}
	}
}
