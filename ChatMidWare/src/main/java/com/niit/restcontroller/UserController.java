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

import com.niit.dao.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;
	@PostMapping(value="/addUser"  )
	public ResponseEntity<String>addUser(@RequestBody User user)
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
    public ResponseEntity<User> get(@PathVariable("userName") String userName){
        
        User user = userDAO.getUser(userName);

        if (user == null){
           
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/UpdateUser/{userName}", method = RequestMethod.PUT)
	    public ResponseEntity<User> update(@PathVariable("userName") String userName){
	       
		   User users = userDAO.getUser(userName);

	        if (users == null){
	            
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }

	                     users.setContactNo(users.getContactNo()); //update more?
	                    
	                       userDAO.updateUser(users);
	        
	        return new ResponseEntity<User>(users, HttpStatus.OK);
	    }

	 @RequestMapping(value ="/deleteUser/{userName}",method=RequestMethod.DELETE)
	 public ResponseEntity<String> deleteuser(@PathVariable("userName")String userName) 
	 {
	       
		   User users = userDAO.getUser("Ben");

	        if (users == null){
	            
	            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
	        }

	                 
	                    
	                       userDAO.deleteUser(users);
	        
	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	    }
	 
	 @PostMapping(value="/login")
	 public ResponseEntity<User>checklogin(@RequestBody User user)
	 {
		 if(userDAO.checkLogin(user))
		 {
			 User user1=(User)userDAO.getUser(user.getUserName());
			 userDAO.updateOnlineStatus("Y", user1);
			 return new ResponseEntity<User>(user1,HttpStatus.OK);
			 
		 }
		 
		 else
		 {
			 return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 @GetMapping(value="/listUsers")
		public ResponseEntity<List<User>> getListUsers()
		{
			
			List<User> listUsers=userDAO.listUser("aa@yahoo.com");
			return new ResponseEntity<List<User>>(listUsers,HttpStatus.OK);

		}
		
}
