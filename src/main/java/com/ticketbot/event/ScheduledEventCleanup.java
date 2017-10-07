package com.ticketbot.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ticketbot.sales.Sale;
import com.ticketbot.sales.SaleArchives;
import com.ticketbot.sales.SaleArchivesRepository;
import com.ticketbot.sales.SaleRepository;

/**
 * <h1>Event Archive Repository Definition</h1>
 * <p>
 * This provides functionality for moving expired <code>Event</code>s to the
 * <code>EventArchive</code> database.
 * </p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Component
public class ScheduledEventCleanup {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private EventArchiveRepository eventArchiveRepository;
	
	@Autowired
	private SaleArchivesRepository saleArchivesRepository;
	
	/**
	 * Scans and moves <code>Event</code> entities every 5 hours.
	 * */
	@Scheduled(cron="0 0 */5 * * *")
	public void scanEvents() {
		List<Event> events = (List<Event>) eventRepository.findAll();
		List<Sale> sales = (List<Sale>)saleRepository.findAll();
		Date date = new Date();
		events.forEach(ev -> {
			try {
				if	(dateFormat.parse(ev.getDate()).before(date)) {
					EventArchive e = new EventArchive(ev);
					eventArchiveRepository.save(e);
					for (Iterator<Sale> iterator = sales.iterator(); iterator.hasNext();) {
						Sale s = iterator.next();
					    if (s.getEvent().getId() == ev.getId()) {
					    	saleArchivesRepository.save(new SaleArchives(s,e));
							saleRepository.delete(s);
					        iterator.remove();
					    }
					}
					eventRepository.delete(ev);
				}
			} catch (ParseException e) {}
		});
	}
}
