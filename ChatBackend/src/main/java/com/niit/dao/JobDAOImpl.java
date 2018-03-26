package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.ApplyJob;
import com.niit.model.Job;

public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
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

	public List<Job> listJob(int jobId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where jobId=:jobId");
		query.setParameter("jobId",jobId);
	
		List<Job> listJobs=query.list();
		return listJobs;
	}

	public boolean applyJob(ApplyJob job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<ApplyJob> getAllApplicationJobDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(" from  ApplyJob");
		query.list();
		List<ApplyJob> applyjoblist=query.list();
		return applyjoblist;
	}

}
