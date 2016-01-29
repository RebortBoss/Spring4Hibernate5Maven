package com.anxpp.demo.core.dao;

import java.util.List;

import com.anxpp.demo.core.entity.User;

public interface DemoDao {
	String test();
	void save(Object entity);
	Object findById(int id);
	void delete(Object entity);
	List<User> findAll();
}
