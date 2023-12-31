package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model for types of bank accounts (checking, savings)
 * @author Colin Knox, Parker Mace, Tyler Rondeau
 */
@Entity
@Table(name = "account_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String type;
}
