package com.ticketbot.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Member Service Definition</h1>
 * 
 * Provides REST functionality.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@CrossOrigin
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	/**
	 * Get All
	 * 
	 * @return List of <code>Member</code>
	 * */
	@RequestMapping("/members")
	public List<Member> getAllMembers(){
		return memberService.getAllMembers();
	}
	
	/**
	 * Get By Id
	 * 
	 * Uses Path Variable
	 * 
	 * @param memberId	Member Id
	 * 
	 * @return <code>Member</code>
	 * */
	@RequestMapping("/members/memberbyid/{memberId}")
	public Member getMemberById(@PathVariable int memberId) {
		return memberService.getMemberById(memberId);
	}
	
	/**
	 * Get By Id
	 * 
	 * Uses Request Parameter
	 * 
	 * @param id	Id
	 * 
	 * @return <code>Member</code>
	 * */
	@RequestMapping("/members/id")
	public Member getById(@RequestParam int id) {
		return memberService.getMemberById(id);
	}
	
	
	/**
	 * Get By First Name
	 * 
	 * Uses Path Variable
	 * 
	 * @param firstName	First Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	@RequestMapping("/members/byfirstname/{firstName}")
	public List<Member> getMembersByFirstName(@PathVariable String firstName){
		return memberService.getMembersByFirstName(firstName);
	}
	
	/**
	 * Get By First Name
	 * 
	 * Uses Request Parameter
	 * 
	 * @param firstName	First Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	@RequestMapping("/members/first")
	public List<Member> getByFirstName(@RequestParam String firstName){
		return memberService.getMembersByFirstName(firstName);
	}
	
	/**
	 * Get By Last Name
	 * 
	 * Uses Path Variable
	 * 
	 * @param lastName	Last Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	@RequestMapping("/members/bylastname/{lastName}")
	public List<Member> getMembersByLastName(@PathVariable String lastName){
		return memberService.getMembersByLastName(lastName);
	}
	
	/**
	 * Get By Last Name
	 * 
	 * Uses Request Parameter
	 * 
	 * @param lastName	Last Name
	 * 
	 * @return List of <code>Member</code>
	 * */
	@RequestMapping("/members/last")
	public List<Member> getByLastName(@RequestParam String lastName){
		return memberService.getMembersByLastName(lastName);
	}
	
	/**
	 * Add Member
	 * 
	 * @param member	Member
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/members")
	public void addMember(@RequestBody Member member) {
		memberService.addMember(member);
	}
	
	/**
	 * Add Member Safely
	 * 
	 * @param firstName	First Name
	 * @param lastName	Last Name
	 * @param email		Email
	 * @param password	Password
	 * */
	@RequestMapping(method=RequestMethod.POST, value="/members/addmember")
	public void addMember(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
		int i = 0;
		List<Member> members = memberService.getAllMembers();
		for	(Member m: members) {
			int j = m.getId();
			if	(j > i) i = j;
		}
		i++;
		memberService.addMember(new Member(i, firstName, lastName,email,password));
	}
	
	/**
	 * Update Member
	 * 
	 * @param member	Member
	 * */
	@RequestMapping(method=RequestMethod.PUT, value="/members")
	public void updateMember(@RequestBody Member member) {
		memberService.updateMember(member);
	}
	
	/**
	 * Delete Member
	 * 
	 * @param id	Id
	 * */
	@RequestMapping(method=RequestMethod.DELETE, value="/members")
	public void deleteMember(int id) {
		memberService.deleteMember(id);
	}
}
