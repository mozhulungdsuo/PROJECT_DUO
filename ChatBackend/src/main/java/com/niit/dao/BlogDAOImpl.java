package com.niit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	//@Override
	public boolean addBlog(Blog blog) {
		
		try
		{
			
			sessionFactory.getCurrentSession().save(blog);
			return true;			
		
		}catch(Exception e)
		{e.printStackTrace();
		  return false;
		}
	}
	@Transactional
	@Override
	public boolean deleteBLog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}
	@Transactional
	@Override
	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);			
		    return true;
		}catch(Exception e)
		{
		      return false;
		}
	}
	@Transactional
	@Override
	public Blog getBlog(int blogid) {
		try{
			Session session=sessionFactory.openSession();

             Blog blog=session.get(Blog.class,blogid);
             session.close();
             System.out.println("yy");
             return blog;		
		} catch (Exception e)
		{
			return null;
		}
	}
	@Transactional
	@Override
	public boolean approveBlog(Blog blog) {
		try{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	@Override
	public boolean rejectBlog(Blog blog) {
		try{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	@Override
	public List<Blog> listBlog(String username) {
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Blog where username = :name",Blog.class);
		query.setParameter("name", username);//user1 is a preexisting user
		List<Blog> pl=query.getResultList();
		return pl;
	}

}
