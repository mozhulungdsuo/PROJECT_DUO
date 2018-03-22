package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Job;
import com.niit.model.User;

public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addUser(User user) {
		try
		{
			
			sessionFactory.getCurrentSession().save(user);
			return true;			
		
		}catch(Exception e)
		{e.printStackTrace();
		  return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);			
		    return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	@Override
	public User getUser(int id) {
		try{
			Session session=sessionFactory.openSession();

             User user=session.get(User.class,id);
             session.close();
             System.out.println("yy");
             return user;		
		} catch (Exception e)
		{
			return null;
		}
	}

}
