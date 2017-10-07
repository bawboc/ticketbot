package com.ticketbot.faces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.faces.repository.SaleJPARepository;
import com.ticketbot.sales.Sale;

import java.util.List;

/**
 * <h1>List Sales</h1>
 * <p>
 * This Controller accompanies the Sale List
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="saleList")
@ELBeanName(value="saleList")
@Join(path="/saleList", to="/sale-list.jsf")
public class SaleListFacesController {

	@Autowired
	private SaleJPARepository saleRepository;
	
	private List<Sale> sales;
	
	/**
	 * Initialize Properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		sales = saleRepository.findAll();
	}

	/**
	 * Get Sales
	 * 
	 * @return List of <code>Sale</code>
	 * */
	public List<Sale> getSales() {
		return sales;
	}

	/**
	 * Set Sales
	 * 
	 * @param sales List of Sales
	 * */
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	
	
}
