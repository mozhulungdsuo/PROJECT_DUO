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

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

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
		
		List<Forum> listForums=forumDAO.listForum("topic");
		return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value="/addForum"  )
	public ResponseEntity<String>addforum(@RequestBody Forum forum)
	{
		System.out.println("rest controller in add");
		
		forum.setCreatedate(new java.util.Date());
	
		forum.setUsername("aben");
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
		 
}
