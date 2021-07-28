package com.project.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.entity.LineItem;

public interface LineReposetory extends JpaRepository<LineItem, Integer> {


}
