package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.User;

public interface Userdao extends JpaRepository<User, Integer> {

	User findByName(String name);


}
