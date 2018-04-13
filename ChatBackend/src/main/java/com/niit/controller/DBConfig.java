package com.niit.controller;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.dao.ForumDAO;
import com.niit.dao.ForumDAOImpl;
import com.niit.dao.JobDAO;
import com.niit.dao.JobDAOImpl;
import com.niit.dao.ProfileUpdateDAO;
import com.niit.dao.ProfileUpdateDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;
import com.niit.model.ApplyJob;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Job;
import com.niit.model.ProfilePicture;
import com.niit.model.UserDetails;
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	  @Autowired
	  @Bean(name="datasource")
	public DataSource getDataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("lung");
	dataSource.setPassword("lung");
	System.out.println("Hello-1");
	return dataSource;
	
	}
	 @Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.dailect","org.hibernate.dailect.Oracle10gDialect");
		hibernateProp.put("hibernate.hbm2ddl.auto","update");	
		hibernateProp.put("hibernate.show_sql","true");
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
	
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
	
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		System.out.println("<--------------Job Class Added-------------->");
		sessionFactoryBuilder.addAnnotatedClass(UserDetails.class);
		System.out.println("<--------------User Class Added-------------->");
		sessionFactoryBuilder.addAnnotatedClass(ApplyJob.class);
		System.out.println("<--------------ApplyJob Class Added-------------->");
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		System.out.println("<--------------BlogComment Class Added-------------->");
		sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		System.out.println("<--------------ForumComment Class Added-------------->");
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addProperties(hibernateProp);
		System.out.println("Table created???");
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("No");
		return sessionFactory;
}
	
	
	
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO()
	{   System.out.println("forumDAO found");
		return new ForumDAOImpl();
	}
	@Bean(name="jobDAO")
	public JobDAO getJobDAOImpl()
	{
		System.out.println("JobDAO found");
		return new JobDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAOImpl()
	{
		System.out.println("UserDAO found");
		return new UserDAOImpl();
	}

	@Bean(name="profilePictureDAO")
	public ProfileUpdateDAO getProfileDAOImpl()
	{
		System.out.println("profile DAO found");
		return new ProfileUpdateDAOImpl();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
		
	}
}
