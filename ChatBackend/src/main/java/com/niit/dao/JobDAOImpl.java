package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.niit.model.Job;

public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addJob(Job job) {
		try
		{
			
			sessionFactory.getCurrentSession().save(job);
			return true;			
		
		}catch(Exception e)
		{e.printStackTrace();
		  return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().update(job);			
		    return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

	@Override
	public Job getJob(int jobId) {
		try{
			Session session=sessionFactory.openSession();

             Job job=session.get(Job.class,jobId);
             session.close();
             System.out.println("yy");
             return job;		
		} catch (Exception e)
		{
			return null;
		}
	}

}
