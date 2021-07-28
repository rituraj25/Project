package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}
