package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDAO blogDAO;
		@GetMapping(value="/demo")
		public ResponseEntity<String> demo()
		{
			return new  ResponseEntity<String>("Demo data",HttpStatus.OK);
		}
		@GetMapping(value="/listBlogs")
		public ResponseEntity<List<Blog>>  getListBlogs()
		{
			List<Blog> listBlogs=blogDAO.listBlog("Tavera");
			if(listBlogs.size()>0)
			{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.NOT_FOUND);
			}
		}
		@PostMapping(value="/addBlog")
		public ResponseEntity<String> addBlog(@RequestBody Blog blog)
		{
		   blog.setCreatedate(new java.util.Date());		 
			blog.setLikes(0);
			blog.setUsername("Ben");
			blog.setStatus("A");
		 if (blogDAO.addBlog(blog))
		 {
			 return new  ResponseEntity<String>("Success",HttpStatus.OK);
			}
		 else
		 {
			 return new  ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		 }
		}
		
		@RequestMapping(value = "/getById/{blogId}", method = RequestMethod.GET)
	    public ResponseEntity<Blog> get(@PathVariable("blogId") int blogId){
	        
	        Blog blog = blogDAO.getBlog(blogId);

	        if (blog == null){
	           
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	    }
		
		 @RequestMapping(value = "/Update/{blogId}", method = RequestMethod.PUT)
		    public ResponseEntity<Blog> update(@PathVariable("blogId") int blogId, @RequestBody Blog blog){
		       
			   Blog blogs = blogDAO.getBlog(blogId);

		        if (blogs == null){
		            
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }

		                     blogs.setBlogContent(blog.getBlogContent()); 
		                    
		                       blogDAO.updateBlog(blogs);
		        
		        return new ResponseEntity<Blog>(blogs, HttpStatus.OK);
		    }
		 @RequestMapping(value ="/delete/{blogId}",method=RequestMethod.DELETE)
		 public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId) 
		 {
		       
			   Blog blogs = blogDAO.getBlog(blogId);

		        if (blogs == null){
		            
		            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		        }

		                  
		                    
		                       blogDAO.deleteBlog(blogs);
		        
		        return new ResponseEntity<String>("Success", HttpStatus.OK);
		    }
		 
		 @RequestMapping(value = "/approve/{blogId}", method = RequestMethod.PUT)
		    public ResponseEntity<Blog> approve(@PathVariable("blogId") int blogId){
		       
			   Blog blogs = blogDAO.getBlog(blogId);

		        if (blogs == null){
		            
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }

		        blogs.setStatus("A");
				blogDAO.approveBlog(blogs);
		        return new ResponseEntity<Blog>(blogs, HttpStatus.OK);
		    }
		 @RequestMapping(value = "/rejectBlog/{blogId}", method = RequestMethod.PUT)
		    public ResponseEntity<Blog> reject(@PathVariable("blogId") int blogId){
		       
			   Blog blogs = blogDAO.getBlog(blogId);

		        if (blogs == null){
		            
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }

		        blogs.setStatus("NA");
				blogDAO.rejectBlog(blogs);
		        return new ResponseEntity<Blog>(blogs, HttpStatus.OK);
		    }
}
