package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Notification;

/**
 * 
 * @author rasco
 *
 */
@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer> {

}