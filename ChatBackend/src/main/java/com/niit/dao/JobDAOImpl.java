package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ApplyJob;
import com.niit.model.Friend;
import com.niit.model.Job;
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
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
	@Transactional
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
	@Transactional
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
@Transactional
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
	@Transactional
	public List<Job> listJob(int jobId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where jobId=:jobId");
		query.setParameter("jobId",jobId);
	
		List<Job> listJobs=query.list();
		return listJobs;
	}
	@Transactional
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
	@Transactional
	public List<ApplyJob> getAllApplicationJobDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(" from  ApplyJob");
		query.list();
		List<ApplyJob> applyjoblist=query.list();
		return applyjoblist;
	}

	@Transactional
	public List<Job> listallJob() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");	
	
		List<Job> listJobs=query.list();
		return listJobs;
	}
	public boolean getApplications(int jobid) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(" from  ApplyJob where jobId=:jobId");
		query.setParameter("jobId", jobid);
		List<ApplyJob> listJobs=query.list();
		if(listJobs.size()>0)
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}

}
