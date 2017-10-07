package com.ticketbot.sales;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Sale Service</h1>
 * 
 * Add communication functionality between <code>SaleRepository</code> and
 * program.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	/**
	 * Get All Sales
	 * 
	 * @return List of <code>Sale</code>
	 * */
	public List<Sale> getAllSales(){
		List<Sale> sales = new ArrayList<>();
		saleRepository.findAll().forEach(sales::add);
		return sales;
	}
	
	/**
	 * Get Sale By Email
	 * 
	 * @param email	Email
	 * 
	 * @return List of <code>Sale</code>
	 * */
	public List<Sale> getSalesByEmail(String email){
		return saleRepository.findByEmail(email);
	}
	
	/**
	 * Get Sale By Id
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Sale</code>
	 * */
	public Sale getSaleById(int id) {
		return saleRepository.findOne(id);
	}
	
	/**
	 * Add Sale
	 * 
	 * @param sale	Sale
	 * */
	public void addSale(Sale sale) {
		saleRepository.save(sale);
	}
	
	/**
	 * Update Sale
	 * 
	 * @param sale	Sale
	 * */
	public void updateSale(Sale sale) {
		saleRepository.save(sale);
	}
	
	/**
	 * Delete Sale
	 * 
	 * @param id	Id
	 * */
	public void deleteSale(int id) {
		saleRepository.delete(id);
	}
}
