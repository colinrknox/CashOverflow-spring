package com.revature.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.revature.dto.RegUserAccountDto;
import com.revature.model.UserAccount;
import com.revature.service.RegisterService;


@CrossOrigin(origins = { "http://localhost:4200", "http://d3nlmo2v0fs5mq.cloudfront.net" })
@RestController
public class RegisterController {

	private RegisterService regServ;
	private ModelMapper mapper;

	private PasswordEncoder enc;

	@Autowired
	public RegisterController(RegisterService regServ, ModelMapper mapper, PasswordEncoder enc) {
		this.regServ = regServ;
		this.mapper = mapper;
		this.enc = enc;
	}

	private UserAccount convertToEntity(RegUserAccountDto dto) {
		return mapper.map(dto, UserAccount.class);
	}

	/**
	 * Takes the data from angular puts it into a dto object, throws a 400 exception
	 * if any values are null. Then passes the data to the service layer to write to
	 * the database.
	 * 
	 * @authors Cameron, Amir, Chandra
	 */
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void newUser(@RequestBody RegUserAccountDto dto) {
		if (dto.getEmail() == null || dto.getUsername() == null || dto.getFirstName() == null
				|| dto.getLastName() == null || dto.getPassword() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing registration info");
		}
		dto.setPassword(enc.encode(dto.getPassword()));
		UserAccount user = convertToEntity(dto);
		regServ.insertUserAccount(user);
	}
}
