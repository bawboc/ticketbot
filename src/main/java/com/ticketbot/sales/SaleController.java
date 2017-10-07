package com.ticketbot.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbot.emails.EmailResponse;
import com.ticketbot.event.Event;
import com.ticketbot.event.EventRepository;

/**
 * <h1>Sale Controller</h1>
 * 
 * Add REST functionality
 * 
 * @author James Lawley
 * @version 1.0
 * */
@CrossOrigin
@RestController
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	EmailResponse emailResponse;
	
	/**
	 * Get All Sales
	 * 
	 * @return List of <code>Sale</code>
	 * */
	@RequestMapping("/sales")
	public List<Sale> getAllSales(){
		return saleService.getAllSales();
	}
	
	/**
	 * Get Sale By Id
	 * 
	 * Uses Path Variable
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Sale</code>
	 * */
	@RequestMapping("/sales/salebyid/{id}")
	public Sale getSaleById(@PathVariable int id) {
		return saleService.getSaleById(id);
	}
	
	/**
	 * Get Sale By Id
	 * 
	 * Uses Request Parameter
	 * 
	 * @param id	ID
	 * 
	 * @return <code>Sale</code>
	 * */
	@RequestMapping("/sales/id")
	public Sale getById(@RequestParam int id) {
		return saleService.getSaleById(id);
	}
	
	/**
	 * Get Sale By Email
	 * 
	 * Uses Path Variable
	 * 
	 * @param email	Email
	 * 
	 * @return List of <code>Sale</code>
	 * */
	@RequestMapping("/sales/salebyemail/{email}")
	public List<Sale> getSalesByEmail(@PathVariable String email){
		return saleService.getSalesByEmail(email);
	}
	
	/**
	 * Get Sale By Email
	 * 
	 * Uses Request Parameter
	 * 
	 * @param email	Email
	 * 
	 * @return List of <code>Sale</code>
	 * */
	@RequestMapping("/sales/email")
	public List<Sale> getByEmail(@RequestParam String email){
		return saleService.getSalesByEmail(email);
	}
	
	/**
	 * Add Sale
	 * 
	 * @param sale	Sale
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/sales")
	public void addSale(@RequestBody Sale sale) {
		saleService.addSale(sale);
	}
	
	/**
	 * Add Sale Without Email - Uses a default email address
	 * 
	 * Calculates totals.
	 * Updates tickets sold/available in <code>Event</code> table.
	 * Sends response.
	 * 
	 * @param firstName		First Name
	 * @param lastName		Last Name
	 * @param eventID		Event Id
	 * @param numTickets	Number of Tickets Purchased
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/sales/newsale")
	public void addSale(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int eventID, @RequestParam int numTickets) {
		String email = "jhlawley@gmail.com";
		Event event = eventRepository.findOne(eventID);
		if	(event.getMaxTickets() >= numTickets && event.getTicketsAvailable() >= numTickets) {
			Sale sale = new Sale();
			sale.setEmail(email);
			sale.setFirstName(firstName);
			sale.setLastName(lastName);
			sale.setEvent(event);
			sale.setNumberOfTickets(numTickets);
			event.ticketsSold(numTickets);
			eventRepository.save(event);
			sale.setTotalPrice(numTickets * event.getTicketPrice());
			saleService.addSale(sale);
			emailResponse.ticketSaleResponse(sale, event);
		}
	}
	
	/**
	 * Add Sale With Email - Uses a provided email address
	 * 
	 * Calculates totals.
	 * Updates tickets sold/available in <code>Event</code> table.
	 * Sends response.
	 * 
	 * @param firstName		First Name
	 * @param lastName		Last Name
	 * @param email			Email
	 * @param eventID		Event Id
	 * @param numTickets	Number of Tickets Purchased
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/sales/new")
	public void addSale(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String email, @RequestParam int eventID, @RequestParam int numTickets) {
		Event event = eventRepository.findOne(eventID);
		if	(event.getMaxTickets() >= numTickets && event.getTicketsAvailable() >= numTickets) {
			Sale sale = new Sale();
			sale.setEmail(email);
			sale.setFirstName(firstName);
			sale.setLastName(lastName);
			sale.setEvent(event);
			sale.setNumberOfTickets(numTickets);
			event.ticketsSold(numTickets);
			eventRepository.save(event);
			sale.setTotalPrice(numTickets * event.getTicketPrice());
			saleService.addSale(sale);
			emailResponse.ticketSaleResponse(sale, event);
		}
		
	}
	
	/**
	 * Update Sale
	 * 
	 * @param sale	Sale
	 * */
	@RequestMapping(method=RequestMethod.PUT, value="/sales")
	public void updateSale(@RequestBody Sale sale) {
		saleService.updateSale(sale);
	}
	
	
	/**
	 * Delete Sale
	 * 
	 * @param id	Id
	 * */
	@RequestMapping(method=RequestMethod.DELETE, value="/sales/{id}")
	public void deleteSale(@PathVariable int id) {
		saleService.deleteSale(id);
	}
}
