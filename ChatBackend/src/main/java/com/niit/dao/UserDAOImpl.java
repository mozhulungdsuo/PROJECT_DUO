package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Job;
import com.niit.model.User;

public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
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

	public List<User> listUser(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where email=:email");
		query.setParameter("email",email);
		List<User> listUsers=query.list();
		return listUsers;
	}

	public boolean checkLogin(User user) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where userName=:userName and password=:pass");
			query.setParameter("userName",user.getUserName());
			query.setParameter("pass", user.getPassword());
			User users=(User)query.list().get(0);
			if(users==null)
				return false;
			else
				return true;
			
	  }
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateOnlineStatus(String status, User user) {
		try
		{
			user.setStatus(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

}
