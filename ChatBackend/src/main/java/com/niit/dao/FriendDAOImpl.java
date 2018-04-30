package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friend;
import com.niit.model.UserDetails;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{

	@Autowired
    SessionFactory sessionFactory;

	@Transactional
	public boolean sendFriendRequest(Friend friend) {

           try
           {
        	   friend.setStatus("P");
        	  System.out.println(friend.getStatus());
        	   
        	   sessionFactory.getCurrentSession().save(friend);
        	   return true;
           }
           catch(Exception e)
           {
        	   return false;
           }
	}
	
	@Transactional
	public boolean deleteFriendRequest(int friendId) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend =(Friend)session.get(Friend.class,friendId);
			
			 sessionFactory.getCurrentSession().delete(friend);
			session.close();
			
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	public List<UserDetails> showSuggestedFriend(String userName) 
	{
		Session session=sessionFactory.openSession();
		
	
		@SuppressWarnings("deprecation")
		Query query=session.createSQLQuery("select * from UserDetails where userName not in(select frienduseName from Friend where userName='" +userName+"')");
		List<UserDetails>suggestFriend=(List<UserDetails>)query.list();
		return suggestFriend;
	}

	public List<Friend> showAllFriends(String userName) 
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Friend where userName=:currentuser and status='A' ");
		query.setParameter("currentuser", userName);
		List<Friend> listFriends=query.list();
		return listFriends;
	}

	public List<Friend> showRequestPendingList(String userName) 
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Friend where userName=:currentuser and status='P' ");
		query.setParameter("currentuser", userName);
		List<Friend> listFriends=query.list();
		return listFriends;
	}
	
	@Transactional
	public boolean acceptFriendRequest(int friendId) 
	{
	 try
	 {
		Session session =sessionFactory.openSession();
		Friend friend =(Friend)session.get(Friend.class,friendId);
		friend.setStatus("A");
		session.close();
		sessionFactory.getCurrentSession().update(friend);
		return true;
	}
	
	 catch(Exception e)
		{
			return false;
		}	
	}

}
