package com.project.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {

	List<SubCategory> findAllByCategory(int id);

	List<SubCategory> findAllByCategoryId(int id);

}
