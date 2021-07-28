package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
