package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {


}
