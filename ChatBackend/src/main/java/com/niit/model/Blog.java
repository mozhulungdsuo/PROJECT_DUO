package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Blog {
@Id
@GeneratedValue
int blogId;
public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public String getBlogName() {
	return blogName;
}
public void setBlogName(String blogName) {
	this.blogName = blogName;
}
public String getBlogContent() {
	return blogContent;
}
public void setBlogContent(String blogContent) {
	this.blogContent = blogContent;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
String blogName;
String blogContent;
Date createdate;
String username;
String status;

}
