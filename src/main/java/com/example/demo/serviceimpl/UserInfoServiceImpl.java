package com.example.demo.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PersonNotAvailableOnThisId;
import com.example.demo.exception.UserNotFoundExceptio;
import com.example.demo.model.UserInformation;
import com.example.demo.pojo.UserPojo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInformation.class);

	@Autowired
	UserRepo userRepo;

	@Override
	public UserPojo saveUserDetails(UserPojo userPojo) {
		// TODO Auto-generated method stub
//		UserInformation user = new UserInformation();
//		user.setFirstName(userPojo.getFirstName());
//		user.setLastName(userPojo.getLastName());
//		user.setEmail(userPojo.getEmail());
//		user.setAddress(userPojo.getAddress());
//		user.setPhoneNumber(userPojo.getPhoneNumber());
//		
//		 userRepo.save(user);

		LOGGER.info("saving the user details");

		UserInformation user = new UserInformation(userPojo.getId(), userPojo.getFirstName(), userPojo.getLastName(),
				userPojo.getEmail(), userPojo.getAddress(), userPojo.getPhoneNumber());
		UserPojo up = new UserPojo();
		UserInformation userInfo = userRepo.save(user);
		BeanUtils.copyProperties(userInfo, up);

		return up;
	}

	@Override
	public List<UserInformation> getAllUserDetails() {
		// TODO Auto-generated method stub

		LOGGER.info("Get the all user details");

		List<UserInformation> users = userRepo.findAll();

		return users;
	}

	@Override
	public UserInformation findByUserDetails(int id) throws UserNotFoundExceptio {
		// TODO Auto-generated method stub

		LOGGER.info("getting the user details based on id ");

		Optional<UserInformation> up = userRepo.findById(id);
		if (up.isEmpty()) {
			throw new UserNotFoundExceptio("please give correct id number to proced ");

		} else {
			return (UserInformation) up.get();
		}

	}

	@Override
	public void userDetailsDeletdById(UserInformation userInformation) {
		// TODO Auto-generated method stub

		LOGGER.info("delete user detalis ");

		userRepo.delete(userInformation);

	}

	@Override
	public UserInformation updateUserDetails(int id, UserPojo userPojo) throws PersonNotAvailableOnThisId {
		// TODO Auto-generated method stub
		LOGGER.info("update user details");
		UserInformation userInformation = userRepo.findById(id)
				.orElseThrow(() -> new PersonNotAvailableOnThisId("please give correct user id"));
		userInformation.setFirstName(userPojo.getFirstName());
		userInformation.setLastName(userPojo.getLastName());
		userInformation.setEmail(userPojo.getEmail());
		userInformation.setAddress(userPojo.getAddress());
		userInformation.setPhoneNumber(userPojo.getPhoneNumber());

		return userRepo.save(userInformation);
	}

}
