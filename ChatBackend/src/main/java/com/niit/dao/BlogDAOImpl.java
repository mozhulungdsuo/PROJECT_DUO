package com.niit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

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
	public List<Blog> listBlog(String username) {
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Blog where username = :name",Blog.class);
		query.setParameter("name", username);//user1 is a preexisting user
		List<Blog> pl=query.getResultList();
		return pl;
	}
	@Transactional
	public boolean incrementLikes(Blog blog) {
		try
		{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public BlogComment getBlogComment(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			BlogComment blogComment=session.get(BlogComment.class,commentId);
			session.close();
			return blogComment;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Transactional
	public List<BlogComment> listBlogComment(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId",blogId);
		List<BlogComment> listBlogComment=((org.hibernate.query.Query) query).list();
		return listBlogComment;
	}
	@Transactional
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);	
			System.out.println("It is really deleted??");
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}

}
