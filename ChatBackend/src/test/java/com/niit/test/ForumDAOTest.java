package com.niit.test;
/*
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.controller.DBConfig;
import com.niit.dao.BlogDAO;
import com.niit.dao.ForumDAO;
import com.niit.model.Blog;
import com.niit.model.Forum;

public class ForumDAOTest {
/*
	private static DBConfig config;
	@Autowired
	private static ForumDAO forumDAO;
	
	@BeforeClass
	
	public static void setup()
	{
		  config = new DBConfig();
	
	     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	      context.scan("com.niit");
	     context.refresh();
	     
	
	forumDAO=(ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void test2() {
		
		Date date = Calendar.getInstance().getTime();
		Forum forum=new Forum();
		
		
		System.out.println(date);
		forum.setForumName("MyNew");
		System.out.println(forum.getForumName());
		forum.setForumContent("ipsumlorem");
		forum.setCreatedate(date);
		forum.setUsername("user1");
		forum.setStatus("A");
		
	     forumDAO.addForum(forum);
		//System.out.println(flag);
		int id=forum.getForumId();
		
		
		
		
		assertNotNull(forumDAO.getForum(id));
		
		
		
		String name="user1";
		List<Forum> pl=forumDAO.listForum(name);
		assertFalse(pl.isEmpty());
		
		
		
		forumDAO.rejectForum(forum);
		assertEquals("NA",forum.getStatus());
	    
		
		forumDAO.deleteForum(forum);
		assertNull(forumDAO.getForum(id));
	    
	
	}
	*/


