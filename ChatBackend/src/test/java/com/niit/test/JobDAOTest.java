package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.controller.DBConfig;
import com.niit.dao.BlogDAO;
import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class JobDAOTest {

	/*
	
	private static DBConfig config;
	@Autowired
	private static JobDAO jobDAO;
	
	@BeforeClass
	
	public static void initialize()
	{
		  config = new DBConfig();
	
	     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	      context.scan("com.niit");
	     context.refresh();
	
	     jobDAO =(JobDAO) context.getBean("jobDAO");
	}
	@Test
	public void insertTest()
	{
		Job job = new Job();

		job.setCompany("ABC pvt.Ltd");
		job.setJobDescription("Food Company");
		job.setFinalDate(new java.util.Date());
		job.setJobTitle("Manager");
		job.setLocation("Pune");
		job.setSalary(45000);
		assertTrue("Data inserted in job table",jobDAO.addJob(job));
	}
	
	@Test
	public void deleteTest()
	{
		  Job job = new Job();
		 job=(Job)jobDAO.getJob(1);
		 assertEquals("sucessfully deleted from table" ,true,jobDAO.deleteJob(job));
	}*/
}
