package com.niit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().save(forum);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}
	@Transactional
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}
	@Transactional
	public boolean updateForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().update(forum);			
		return true;
		}catch(Exception e)
		{
		      return false;
		}
	}
	@Transactional
	public Forum getForum(int forumId) {
		try{
			Session session=sessionFactory.openSession();

             Forum forum=session.get(Forum.class,forumId);
             session.close();
             return forum;		
		} catch (Exception e)
		{
			return null;
		}
	}
	@Transactional
	public boolean approveForum(Forum forum) {
		try{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean rejectForum(Forum forum) {
		try{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public List<Forum> listForum(String username) {
Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Forum where username = :name",Forum.class);
		query.setParameter("name", username);//user1 is a preexisting user
		List<Forum> pl=query.getResultList();
		return pl;
	}
	
	public boolean addForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deleteForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public ForumComment getForumComment(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			ForumComment forumComment=session.get(ForumComment.class,commentId);
			session.close();
			return forumComment;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public List<ForumComment> listForumComment(int forumId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId",forumId);		
		List<ForumComment> listForumComment=((org.hibernate.query.Query) query).list();
		return listForumComment;
	}

}
