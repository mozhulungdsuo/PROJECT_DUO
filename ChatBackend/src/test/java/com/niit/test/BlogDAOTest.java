package com.niit.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.niit.controller.DBConfig;
import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.model.Blog;
@Transactional
public class BlogDAOTest {
	
	private static DBConfig config;
	@Autowired
	private static BlogDAO blogDAO;
	
	@BeforeClass
	
	public static void initialize()
	{
		  config = new DBConfig();
	
	     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	      context.scan("com.niit");
	     context.refresh();
	
	blogDAO =(BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void test() {
		
		Date date = Calendar.getInstance().getTime();
		Blog blog=new Blog();
		//blog.setBlogId(1);
		
		System.out.println(date);
		blog.setBlogName("MyNew");
		System.out.println(blog.getBlogName());
		blog.setBlogContent("ipsumlorem");
		blog.setCreatedate(date);
		blog.setUsername("user1");
		blog.setStatus("A");
		//assertNull(blog);
	     blogDAO.addBlog(blog);
		//System.out.println(flag);
		int id=blog.getBlogId();
		//System.out.println(id);
		//assertNotEquals(blogDAO.getBlog(id));
		
		
		
		assertNotNull(blogDAO.getBlog(id));
		
		
		
		String name="user1";
		List<Blog> pl=blogDAO.listBlog(name);
		assertFalse(pl.isEmpty());
		
		
		
		blogDAO.rejectBlog(blog);
		assertEquals("NA",blog.getStatus());
	    
		
		blogDAO.deleteBlog(blog);
		assertNull(blogDAO.getBlog(id));
	    
	
	}
	

}
