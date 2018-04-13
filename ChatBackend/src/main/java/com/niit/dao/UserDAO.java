package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetails;

public interface UserDAO {
	public boolean addUser(UserDetails user);
	public boolean deleteUser(UserDetails user);
	public boolean updateUser(UserDetails user);
	public UserDetails getUser(String userName);
	public List<UserDetails> listUser(String email);
	public boolean checkLogin(UserDetails user);
	public boolean updateOnlineStatus(String status, UserDetails user);



}
