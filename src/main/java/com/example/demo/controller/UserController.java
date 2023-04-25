package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PersonNotAvailableOnThisId;
import com.example.demo.exception.UserNotFoundExceptio;
import com.example.demo.model.UserInformation;
import com.example.demo.pojo.UserPojo;
import com.example.demo.service.UserInfoService;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInformation.class);

	@Autowired
	UserInfoService userInfoService;

	@PostMapping("/save")
	public ResponseEntity<UserPojo> detailsSaved(@RequestBody UserPojo userPojo) {

		LOGGER.info("user details saved in database");
		UserPojo us = userInfoService.saveUserDetails(userPojo);
		if (us != null) {
			return new ResponseEntity<UserPojo>(us, HttpStatus.ACCEPTED);
		} else {

			return new ResponseEntity<UserPojo>(us, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserInformation>> allUsers() {

		LOGGER.info("getting the user details from data base");

		List<UserInformation> ud = userInfoService.getAllUserDetails();

		if (ud != null) {
			return new ResponseEntity<List<UserInformation>>(ud, HttpStatus.ACCEPTED);

		} else {

			return new ResponseEntity<List<UserInformation>>(ud, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/user{id}")
	public ResponseEntity<UserInformation> getByIdUser(@PathVariable int id) throws UserNotFoundExceptio {

		LOGGER.info("getting the user details based on user id ");

		UserInformation uk = userInfoService.findByUserDetails(id);

		if (uk != null) {
			return new ResponseEntity<UserInformation>(uk, HttpStatus.ACCEPTED);

		} else {

			return new ResponseEntity<UserInformation>(uk, HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<UserInformation> deleteUserDetailsBasedOnId(@PathVariable int id) throws UserNotFoundExceptio {

		LOGGER.info("deleting the user details in database");

		UserInformation ua = null;

		ua = userInfoService.findByUserDetails(id);
		userInfoService.userDetailsDeletdById(ua);

		if (ua != null) {
			return new ResponseEntity<UserInformation>(ua, HttpStatus.ACCEPTED);

		} else {

			return new ResponseEntity<UserInformation>(ua, HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserInformation> DetailsAreUpdated(@PathVariable int id,@RequestBody UserPojo userPojo) throws PersonNotAvailableOnThisId{
		
		UserInformation uu = userInfoService.updateUserDetails(id, userPojo);
		
		if (uu!=null) {
			return new ResponseEntity<UserInformation>(uu,HttpStatus.ACCEPTED);
			
		}else {
			return new ResponseEntity<UserInformation>(uu,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	

}
