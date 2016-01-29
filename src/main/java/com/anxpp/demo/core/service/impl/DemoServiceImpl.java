package com.anxpp.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anxpp.demo.core.dao.DemoDao;
import com.anxpp.demo.core.entity.User;
import com.anxpp.demo.core.service.DemoService;
/**
 * Service
 * 
 * @author anxpp.com
 *
 */
//@Transactional  多次操作数据库请打开事务，可以只放到一个方法上面
@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	DemoDao demoDao;

	public String test() {
		return demoDao.test();
	}

	public Object save(String name) {
		User user = new User(name);
		demoDao.save(user);
		return user;
	}

	public boolean delete(int id) {
		User user = (User) demoDao.findById(id);
		if(user==null)
			return false;
		demoDao.delete(user);
		return true;
	}

	public String findAll() {
		String r = "";
		for(User user:demoDao.findAll())
			r +=  user;
		return r;
	}

}
