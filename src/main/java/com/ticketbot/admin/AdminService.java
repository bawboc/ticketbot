package com.ticketbot.admin;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbot.emails.EmailResponse;
/**
 * <h1><code>AdminService</code> Definition</h1>
 * Provides Communication between <code>AdminRepository</code> and 
 * the rest of the program.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmailResponse emailResponse;
	
	/**
	 * Get All Admins
	 * 
	 * @return List of all <code>Admin</code> entities.
	 * */
	public List<Admin> getAllAdmins(){
		List<Admin> admins = new ArrayList<>();
		adminRepository.findAll().forEach(admins::add);
		return admins;
	}
	
	/**
	 * Get Admin By Email
	 * 
	 * @param email Email
	 * 
	 * @return <code>Admin</code>
	 * */
	public Admin getAdminByEmail(String email) {
		return adminRepository.findByEmail(email);
	}
	
	/**
	 * Get Admin By ID
	 * 
	 * @param id Id
	 * 
	 * @return <code>Admin</code>
	 * */
	public Admin getAdminById(int id) {
		return adminRepository.findOne(id);
	}
	
	/**
	 * Add Admin
	 * 
	 * @param admin Admin
	 * */
	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
		emailResponse.grantedAdminResponse(admin.getEmail());
	}
	
	/**
	 * Delete Admin
	 * 
	 * @param id Id
	 * */
	public void deleteAdmin(int id) {
		adminRepository.delete(id);
	}
}
