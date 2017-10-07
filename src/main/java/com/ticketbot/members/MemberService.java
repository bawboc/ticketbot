package com.ticketbot.members;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Member Service Definition</h1>
 * 
 * Facilitates communication between Repository and Controller
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	/**
	 * Get All
	 * 
	 * @return List of <code>Member</code>
	 * */
	public List<Member> getAllMembers(){
		List<Member> members = new ArrayList<>();
		memberRepository.findAll().forEach(members::add);
		return members;
	}
	
	/**
	 * Get By Id
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Member</code>
	 * */
	public Member getMemberById(int id) {
		return memberRepository.findOne(id);
	}
	
	/**
	 * Get By First Name
	 * 
	 * @param firstName	First Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	public List<Member> getMembersByFirstName(String firstName){
		return memberRepository.findByFirstName(firstName);
	}
	
	
	/**
	 * Get By Last Name
	 * 
	 * @param lastName	Last Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	public List<Member> getMembersByLastName(String lastName){
		return memberRepository.findByLastName(lastName);
	}
	
	/**
	 * Add Member
	 * 
	 * @param member	Member
	 * */
	public void addMember(Member member) {
		memberRepository.save(member);
	}
	
	/**
	 * Update Member
	 * 
	 * @param member	Member
	 * */
	public void updateMember(Member member) {
		memberRepository.save(member);
		
	}
	
	/**
	 * Delete Member
	 * 
	 * @param id	Id
	 * */
	public void deleteMember(int id) {
		memberRepository.delete(id);
	}
}
