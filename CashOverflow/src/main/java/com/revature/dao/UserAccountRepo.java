package com.revature.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.UserAccount;

/**
 * 
 * @author rasco
 *
 */
@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	
	/***
	 * Method to login to the application
	 * @param username - username enter to log in
	 * @param password - password enter to log in
	 * @return - User object
	 */
	public UserAccount findByUsernameAndPassword(String username, String password);
}
