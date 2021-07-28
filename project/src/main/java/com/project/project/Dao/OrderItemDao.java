package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {

}
