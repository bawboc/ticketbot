package com.ticketbot.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbot.event.EventArchive;

/**
 * <h1>Sale Archives Service</h1>
 * 
 * Facilitates communication between repository and program.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class SaleArchivesService {

	@Autowired
	private SaleArchivesRepository saleArchivesRepository;
	
	/**
	 * Add Sale Archive
	 * 
	 * @param sale			Sale
	 * @param eventArchive	Event Archive
	 * */
	public void addSaleArchives(Sale sale, EventArchive eventArchive) {
		saleArchivesRepository.save(new SaleArchives(sale,eventArchive));
	}
}
