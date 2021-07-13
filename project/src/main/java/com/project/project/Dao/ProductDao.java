package com.project.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findAllBySubCategoryId(int id);

}
