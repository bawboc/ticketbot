package com.ticketbot.faces.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbot.members.Member;

/**
 * <h1>Member JPA Repository</h1>
 * 
 * <p>Adds basic CRUD functionality</p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface MemberJPARepository extends JpaRepository<Member, Integer> {

}
