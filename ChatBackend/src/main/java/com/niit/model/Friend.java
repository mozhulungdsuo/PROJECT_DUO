package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Friend {
	@Id
	@GeneratedValue(generator = "friend_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "friend_sequence", sequenceName = "friend_seq", initialValue = 1, allocationSize = 1)
	int friendId;
	String userName;
	String frienduseName;
	String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFrienduseName() {
		return frienduseName;
	}
	public void setFrienduseName(String frienduseName) {
		this.frienduseName = frienduseName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}