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
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.UserDetails;

@RestController
public class FriendController {
	
@Autowired
FriendDAO friendDAO;
@PostMapping(value="/sendFriendRequest/{frienduseName}",headers = {"Accept=application/json"})
public ResponseEntity<String> sendFriendRequest(@PathVariable("frienduseName") String frienduseName,HttpSession session)
{
	Friend friend = new Friend();
	friend.setStatus("P");
	friend.setUserName((String)session.getAttribute("userName"));
	friend.setFrienduseName(frienduseName);
	if(friendDAO.sendFriendRequest(friend))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@PostMapping(value="/deleteFriendRequest/{friendId}")
public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId") int friendId)
{
	
	if(friendDAO.deleteFriendRequest(friendId))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping(value="/acceptFriendRequest/{friendId}")
public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId") int friendId)
{
	
	if(friendDAO.acceptFriendRequest(friendId))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping(value="/showAllFriends/{userName}")
public ResponseEntity<List<Friend>> showAllFriends(HttpSession session,@PathVariable("userName") String userName)
{
	
   //String userName=((UserDetails)session.getAttribute("userName")).getUserName();
   List<Friend>listAllFriend=friendDAO.showAllFriends(userName);
	
	if(listAllFriend.size()>0)
	{
		return new ResponseEntity<List<Friend>>(listAllFriend,HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<List<Friend>>(listAllFriend,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping(value="/showPendingRequest/{userName}")
public ResponseEntity<List<Friend>> showPendingRequest(HttpSession session,@PathVariable("userName") String userName)
{
	
   //String userName=((UserDetails)session.getAttribute("userName")).getUserName();
   List<Friend>listPendingRequestsFriend=friendDAO.showRequestPendingList(userName);
	
System.out.println(listPendingRequestsFriend.size()+" is pending");
	if(listPendingRequestsFriend.size()>0)
	{
		return new ResponseEntity<List<Friend>>(listPendingRequestsFriend,HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<List<Friend>>(listPendingRequestsFriend,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@GetMapping(value="/testFriends")
public ResponseEntity<List<UserDetails>> testFriends(HttpSession session)
{
	System.out.println("Test 1");
   String userName= ((String) session.getAttribute("userName"));
   System.out.println("Test 12");
   List<UserDetails>listAllFriend=friendDAO.showSuggestedFriend(userName);
	
	if(listAllFriend.size()>0)
	{
		return new ResponseEntity<List<UserDetails>>(listAllFriend,HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<List<UserDetails>>(listAllFriend,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping(value="/showPendingRequestNumber/{userName}")
public int showPendingRequestNumber(HttpSession session,@PathVariable("userName") String userName)
{
	
   
	//String userName="a";
   List<Friend>listPendingRequestsFriend=friendDAO.showRequestPendingList(userName);
	
System.out.println(listPendingRequestsFriend.size()+" is pending");
	if(listPendingRequestsFriend.size()>0)
	{
		return listPendingRequestsFriend.size();
		
	}
	else
	{
		return  0;
	}
}

}
	