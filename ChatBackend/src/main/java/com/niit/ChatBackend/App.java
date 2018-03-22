package com.niit.ChatBackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.model.Blog;

public class App {
	
  	 

	public static void main(String[] args) {
		/* String url = "jdbc:oracle:thin:@localhost:1521:XE";
	        String username = "lung";
	        String password = "lung";

	        String sql = "SELECT * FROM test";
	        Connection connection;
	        try {
	            connection = DriverManager.getConnection(url, username, password);
	            Statement statement = connection.createStatement();
	            System.out.println(statement.execute(sql));
	            connection.close();
	        } catch (SQLException e) {
	            System.err.println(e);
	        }
        */
		  //@Autowiredconnect con
	
	}

}
