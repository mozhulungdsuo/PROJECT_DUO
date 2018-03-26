package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

public interface BlogDAO {
public boolean addBlog(Blog blog);
public boolean deleteBlog(Blog blog);
public boolean updateBlog(Blog blog);
public Blog getBlog(int blogid);
public boolean approveBlog(Blog blog);
public boolean rejectBlog(Blog blog);
public List<Blog> listBlog(String username);
public boolean incrementLikes(Blog blog);


public boolean addBlogComment(BlogComment blogComment);
public boolean deleteBlogComment(BlogComment blogComment);
public BlogComment getBlogComment(int commentId);
public List<BlogComment>listBlogComment (int blogId);


}
