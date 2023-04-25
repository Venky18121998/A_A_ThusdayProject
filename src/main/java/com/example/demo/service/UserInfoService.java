package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.PersonNotAvailableOnThisId;
import com.example.demo.exception.UserNotFoundExceptio;
import com.example.demo.model.UserInformation;
import com.example.demo.pojo.UserPojo;

public interface UserInfoService {

	public UserPojo saveUserDetails(UserPojo userPojo);

	public List<UserInformation> getAllUserDetails();

	public UserInformation findByUserDetails(int id) throws UserNotFoundExceptio;

	void userDetailsDeletdById(UserInformation userInformation);

	public UserInformation updateUserDetails(int id, UserPojo userPojo) throws PersonNotAvailableOnThisId;

}
