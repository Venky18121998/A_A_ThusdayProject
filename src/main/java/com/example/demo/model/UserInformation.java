package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_information_details")
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;

}
