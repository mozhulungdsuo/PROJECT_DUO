package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Job;
import com.niit.model.UserDetails;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addUser(UserDetails user) {
		try
		{
			
			sessionFactory.getCurrentSession().save(user);
			return true;			
		
		}catch(Exception e)
		{e.printStackTrace();
		  return false;
		}
	}

	public boolean deleteUser(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	public boolean updateUser(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);			
		    return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	public UserDetails getUser(int id) {
		try{
			Session session=sessionFactory.openSession();

             UserDetails user=session.get(UserDetails.class,id);
             session.close();
             
             return user;		
		} catch (Exception e)
		{
			return null;
		}
	}

	public List<UserDetails> listUser(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails where email=:email");
		query.setParameter("email",email);
		List<UserDetails> listUsers=query.list();
		return listUsers;
	}

	public boolean checkLogin(UserDetails user) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetails where userName=:userName and password=:pass");
			query.setParameter("userName",user.getUserName());
			query.setParameter("pass", user.getPassword());
			UserDetails users=(UserDetails)query.list().get(0);
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

	public boolean updateOnlineStatus(String status, UserDetails user) {
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

	public UserDetails getUser(String userName) {
		try
		{
			Session session=sessionFactory.openSession();
			UserDetails user=session.get(UserDetails.class,userName);
			session.close();
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
