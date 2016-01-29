package com.anxpp.demo.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.anxpp.demo.core.dao.DemoDao;
import com.anxpp.demo.core.entity.User;
/**
 * dao
 * 
 * @author anxpp.com
 *
 */
@Repository
public class DemoDaoImpl implements DemoDao {
	
	@Autowired
	protected HibernateTemplate hibernateTemplateMysql;

	public String test() {
		return "hello word!";
	}

	public void save(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	public void delete(Object entity) {
		hibernateTemplateMysql.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return (List<User>) hibernateTemplateMysql.find("from User");
	}
	@SuppressWarnings({ })
	public Object findById(final int id) {
//		return hibernateTemplateMysql.execute(new HibernateCallback() {
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException {
//				String hql = "from User where id=?";
//				Query query = session.createQuery(hql);
//				query.setParameter(0, id);
//				return query.uniqueResult();
//			}
//		});
		return hibernateTemplateMysql.execute((Session session)-> {
				String hql = "from User where id=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, id);
				return query.uniqueResult();
		});
	}

}
