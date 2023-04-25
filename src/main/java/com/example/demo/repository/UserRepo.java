package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserInformation;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<UserInformation, Integer> {

}
