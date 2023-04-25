package com.example.demo.controllertesting;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.demo.controller.UserController;
import com.example.demo.exception.PersonNotAvailableOnThisId;
import com.example.demo.exception.UserNotFoundExceptio;
import com.example.demo.model.UserInformation;
import com.example.demo.pojo.UserPojo;
import com.example.demo.serviceimpl.UserInfoServiceImpl;

@ExtendWith(SpringExtension.class)
public class UserControllerTesting {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserInfoServiceImpl userInfoServiceImpl;
	
	@Test
	@Order(1)
	public void detailsSaved_Test() {
		UserPojo up = new UserPojo(1, "venky", "nalamalapu", "venky@gmail.com", "andra", "7995977969");
		
		when(userInfoServiceImpl.saveUserDetails(up)).thenReturn(up);
		ResponseEntity<UserPojo> upp = userController.detailsSaved(up);
		assertEquals(HttpStatus.ACCEPTED, upp.getStatusCode());

	}
	
	@Test
	@Order(11)
	public void detailsSaved() {
		when(userInfoServiceImpl.saveUserDetails(null)).thenReturn(null);
		ResponseEntity<UserPojo> upp = userController.detailsSaved(null);
		assertEquals(HttpStatus.BAD_REQUEST, upp.getStatusCode());
		
	}
	
	@Test
	@Order(2)
	
	public void allUsers_Test() {
		List<UserInformation> user = new ArrayList<UserInformation>();
				user.add(new  UserInformation(1, "venky", "nalamalapu", "venky@gmail.com", "andra", "7995977969"));
		
		when(userInfoServiceImpl.getAllUserDetails()).thenReturn(user);
		ResponseEntity<List<UserInformation>> uk = userController.allUsers();
		assertEquals(HttpStatus.ACCEPTED, uk.getStatusCode());
	}
	
	@Test
	@Order(12)
	public void allUsers() {
		when(userInfoServiceImpl.getAllUserDetails()).thenReturn(null);
		ResponseEntity<List<UserInformation>> uk = userController.allUsers();
		assertEquals(HttpStatus.BAD_REQUEST, uk.getStatusCode());
	}
	
	@Test
	@Order(3)
	public void getByIdUser_Test() throws UserNotFoundExceptio {
		UserInformation userInformation = new UserInformation(1, "venky", "nalamalapu", "venky@gmail.com", "andra", "7995977969");
		int id = 1;
		
		when(userInfoServiceImpl.findByUserDetails(id)).thenReturn(userInformation);
		ResponseEntity<UserInformation> us = userController.getByIdUser(id);
		assertEquals(HttpStatus.ACCEPTED, us.getStatusCode());
		
		
	}
	
	@Test
	@Order(13)
	public void getByIdUser() throws UserNotFoundExceptio {
		int id = 12;
		when(userInfoServiceImpl.findByUserDetails(id)).thenReturn(null);
		ResponseEntity<UserInformation> us = userController.getByIdUser(id);
		assertEquals(HttpStatus.BAD_REQUEST, us.getStatusCode());
	}

	@Test
	@Order(4)
	public void deleteUserDetailsBasedOnId_Test() throws UserNotFoundExceptio {
		
		UserInformation userInfo = new UserInformation(1, "venky", "nalamalapu", "venky@gmail.com", "andra", "7995977969");
		int id = 1;
		Mockito.when(userInfoServiceImpl.findByUserDetails(id)).thenReturn(userInfo);
		ResponseEntity<UserInformation> uuu = userController.deleteUserDetailsBasedOnId(id);
		assertEquals(HttpStatus.ACCEPTED, uuu.getStatusCode());
		
	}
	
	@Test
	@Order(14)
	public void deleteUserDetailsBasedOnId() throws UserNotFoundExceptio {
		int id = 1;
		Mockito.when(userInfoServiceImpl.findByUserDetails(id)).thenReturn(null);
		ResponseEntity<UserInformation> uuu = userController.deleteUserDetailsBasedOnId(id);
		assertEquals(HttpStatus.BAD_REQUEST, uuu.getStatusCode());
		
	}
	
	@Test
	@Order(5)
	public void DetailsAreUpdated_Test() throws PersonNotAvailableOnThisId {
		
		UserPojo up = new UserPojo(1, "venky", "nalamalapu", "venky@gmail.com", "andra", "7995977969");
		UserInformation userInfo = new UserInformation(5, "venkat", "nalama", "venkat@gmail.com", "andhra", "799597");
		int id = 5;
		Mockito.when(userInfoServiceImpl.updateUserDetails(id, up)).thenReturn(userInfo);
		ResponseEntity<UserInformation> use = userController.DetailsAreUpdated(id, up);
		assertEquals(HttpStatus.ACCEPTED, use.getStatusCode());
		
	}
	
	@Test
	@Order(15)
	public void DetailsAreUpdated() throws PersonNotAvailableOnThisId {
		int id = 5;
		Mockito.when(userInfoServiceImpl.updateUserDetails(id, null)).thenReturn(null);
		ResponseEntity<UserInformation> use = userController.DetailsAreUpdated(id, null);
		assertEquals(HttpStatus.BAD_REQUEST, use.getStatusCode());
		
	}
}
