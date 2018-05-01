package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.niit.dao.ForumDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

@RestController
public class ForumController {
	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping(value="/demoforum")
	public ResponseEntity<String> demoforum()
	{
	
		return new ResponseEntity<String>("Demo Data",HttpStatus.OK);
	
	}
	

	
	@GetMapping(value="/listForums")
	public ResponseEntity<List<Forum>> getListForums()
	{
		
		List<Forum> listForums=forumDAO.listForum();
		if(listForums.size()>0)
		{
		return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping(value="/addForum"  )
	public ResponseEntity<String>addforum(@RequestBody Forum forum,HttpSession session)
	{
		System.out.println("rest controller in add");
		
		forum.setCreatedate(new java.util.Date());
	
		forum.setUsername((String)session.getAttribute("userName"));
		forum.setStatus("A");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	
	@RequestMapping(value = "/getForumById/{forumId}", method = RequestMethod.GET)
    public ResponseEntity<Forum> get(@PathVariable("forumId") int forumId){
        
        Forum forum = forumDAO.getForum(forumId);

        if (forum == null){
           
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Forum>(forum, HttpStatus.OK);
    }
	
	

		 @RequestMapping(value = "/Updateforum/{forumId}", method = RequestMethod.PUT)
		    public ResponseEntity<Forum> update(@PathVariable("forumId") int forumId, @RequestBody Forum forum){
		       
			   Forum forums = forumDAO.getForum(forumId);

		        if (forums == null){
		            
		            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		        }

		                     forums.setForumName(forum.getForumName()); 
		                    
		                       forumDAO.updateForum(forums);
		        
		        return new ResponseEntity<Forum>(forums, HttpStatus.OK);
		    }
	
		 
		 
		 
	
		 
		 @RequestMapping(value ="/deleteforum/{forumId}",method=RequestMethod.DELETE)
		 public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId) 
		 {
		       
			   Forum forum = forumDAO.getForum(forumId);

		        if (forum == null){
		            
		            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		        }

		                   //  blogs.setBlogContent(blog.getBlogContent()); 
		                    
		                       forumDAO.deleteForum(forum);
		        
		        return new ResponseEntity<String>("Success", HttpStatus.OK);
		    }
		 
		
		 
		 
		 @RequestMapping(value = "/approveforum/{forumId}", method = RequestMethod.PUT)
		    public ResponseEntity<Forum> approve(@PathVariable("forumId") int forumId){
		       
			   Forum forums = forumDAO.getForum(forumId);

		        if (forums == null){
		            
		            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		        }

		        forums.setStatus("A");
				forumDAO.approveForum(forums);
		        return new ResponseEntity<Forum>(forums, HttpStatus.OK);
		    }
		 
		
		 @RequestMapping(value = "/rejectforum/{forumId}", method = RequestMethod.PUT)
		    public ResponseEntity<Forum> reject(@PathVariable("forumId") int forumId){
		       
			   Forum forums = forumDAO.getForum(forumId);

		        if (forums == null){
		            
		            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		        }

		        forums.setStatus("NA");
				forumDAO.rejectForum(forums);
		        return new ResponseEntity<Forum>(forums, HttpStatus.OK);
		    }
		 
		 @PostMapping(value="/addForumComment/{forumId}"  )
		  	public ResponseEntity<String>addForumComment(@RequestBody ForumComment forumcomment,@PathVariable("forumId")int forumId, HttpSession session)
		  	{
		  		System.out.println("in add comment control");
		  		forumcomment.setForumId(forumId);
		     	forumcomment.setCommentDate(new java.util.Date());
		  	    forumcomment.setUserName((String)session.getAttribute("userName"));
		   		
		  				
		  				
		  		if(forumDAO.addForumComment(forumcomment))
		  		{
		  			return new ResponseEntity<String>("Success",HttpStatus.OK);
		  		}
		  		else
		  		{
		  			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		  		}
		  		
		  		
		  	}
		 @RequestMapping(value ="/deleteForumComment/{commentId}",method=RequestMethod.DELETE)
	 	 public ResponseEntity<String> deleteForumComment(@PathVariable("commentId") int commentId) 
	 	 {
	 	       
	 		   ForumComment comments = forumDAO.getForumComment(commentId);

	 	        if (comments == null){
	 	            
	 	            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
	 	        }

	 
	 	                    
	 	                       forumDAO.deleteForumComment(comments);
	 	        
	 	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	 	    }

		 @RequestMapping(value = "/getByForumCommentId/{commentId}", method = RequestMethod.GET)
	      public ResponseEntity<ForumComment> getComment(@PathVariable("commentId") int commentId){
	          
	          ForumComment comments = forumDAO. getForumComment(commentId);

	          if (comments == null){
	             
	              return new ResponseEntity<ForumComment>(HttpStatus.NOT_FOUND);
	          }

	          return new ResponseEntity<ForumComment>(comments, HttpStatus.OK);
	      }
		 @GetMapping(value="/listForumComments/{forumId}")
		  	public ResponseEntity<List<ForumComment>> getListBlogComment(@PathVariable("forumId")int forumId)
		  	{
		  		
		  		List<ForumComment> listForumComments=forumDAO.listForumComment(forumId);
		  		return new ResponseEntity<List<ForumComment>>(listForumComments,HttpStatus.OK);
		  		
		  	}
}
