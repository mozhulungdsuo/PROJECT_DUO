package com.niit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.Forum;

public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public List<Forum> listForum(String username) {
Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Forum where username = :name",Forum.class);
		query.setParameter("name", username);//user1 is a preexisting user
		List<Forum> pl=query.getResultList();
		return pl;
	}

}
