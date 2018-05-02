package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfileUpdateDAOImpl implements ProfileUpdateDAO {
	 @Autowired
	    SessionFactory sessionFactory;
   @Transactional
	public void save(ProfilePicture profilePicture) 
	{
		
	   Session session=sessionFactory.getCurrentSession();
		//Object obj=session.get(ProfilePicture.class,profilePicture.getLoginName());
     session.saveOrUpdate(profilePicture);
   
	}
@Transactional
	public ProfilePicture getProfilePicture(String userName) 
	{
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, userName);
		return profilePicture;
		
	}
}
