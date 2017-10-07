package com.ticketbot.members;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * <h1>Member Repository Definition</h1>
 * 
 * Communicates with database.
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface MemberRepository extends CrudRepository<Member, Integer> {
	
	/**
	 * Find <code>Member</code> By First Name
	 * 
	 * @param firstName	First Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	public List<Member> findByFirstName(String firstName);
	
	/**
	 * Find <code>Member</code> By Last Name
	 * 
	 * @param lastName	Last Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	public List<Member> findByLastName(String lastName);
	
	/**
	 * Find <code>Member</code> By Email
	 * 
	 * @param email	Email
	 * 
	 * @return List of <code>Member</code>
	 * */
	public Member findByEmail(String email);
}
