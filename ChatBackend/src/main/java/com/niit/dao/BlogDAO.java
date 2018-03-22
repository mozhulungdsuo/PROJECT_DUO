package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {
public boolean addBlog(Blog blog);
public boolean deleteBLog(Blog blog);
public boolean updateBlog(Blog blog);
public Blog getBlog(int blogid);
public boolean approveBlog(Blog blog);
public boolean rejectBlog(Blog blog);
public List<Blog> listBlog(String username);

}
