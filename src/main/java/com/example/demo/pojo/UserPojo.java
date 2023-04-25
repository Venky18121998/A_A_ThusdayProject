package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;

}
