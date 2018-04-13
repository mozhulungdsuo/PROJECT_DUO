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

import com.niit.dao.UserDAO;
import com.niit.model.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	@PostMapping(value="/addUser"  )
	public ResponseEntity<String>addUser(@RequestBody UserDetails user)
	{
		
		
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
		
		
	}
	@RequestMapping(value = "/getUserById/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> get(@PathVariable("userName") String userName){
        
        UserDetails user = userDAO.getUser(userName);

        if (user == null){
           
            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/UpdateUser/{userName}", method = RequestMethod.PUT)
	    public ResponseEntity<UserDetails> update(@PathVariable("userName") String userName){
	       
		   UserDetails users = userDAO.getUser(userName);

	        if (users == null){
	            
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }

	                     users.setContactNo(users.getContactNo()); //update more?
	                    
	                       userDAO.updateUser(users);
	        
	        return new ResponseEntity<UserDetails>(users, HttpStatus.OK);
	    }

	 @RequestMapping(value ="/deleteUser/{userName}",method=RequestMethod.DELETE)
	 public ResponseEntity<String> deleteuser(@PathVariable("userName")String userName) 
	 {
	       
		   UserDetails users = userDAO.getUser("Ben");

	        if (users == null){
	            
	            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
	        }

	                 
	                    
	                       userDAO.deleteUser(users);
	        
	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	    }
	 
	 @PostMapping(value="/login")
	 public ResponseEntity<UserDetails>checklogin(@RequestBody UserDetails user,HttpSession session)
	 {
		 if(userDAO.checkLogin(user))
		 {
			 UserDetails user1=(UserDetails)userDAO.getUser(user.getUserName());
			 userDAO.updateOnlineStatus("Y", user1);
			 session.setAttribute("username",user.getUserName());
			 return new ResponseEntity<UserDetails>(user1,HttpStatus.OK);
			 
		 }
		 
		 else
		 {
			 return new ResponseEntity<UserDetails>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 @GetMapping(value="/listUsers")
		public ResponseEntity<List<UserDetails>> getListUsers()
		{
			
			List<UserDetails> listUsers=userDAO.listUser("aben@gmail.com");
			return new ResponseEntity<List<UserDetails>>(listUsers,HttpStatus.OK);

		}
		
}
