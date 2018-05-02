package com.niit.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.ProfileUpdateDAO;
import com.niit.model.ProfilePicture;
import com.niit.model.UserDetails;

@RestController
public class ProfilePictureController {
	@Autowired
    ProfileUpdateDAO profileUpdateDAO;
	
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public void uploadPicture(@RequestParam(value="file1") CommonsMultipartFile fileupload,HttpSession session,UserDetails userDetails)
    {
    	 
      String user1=(String) session.getAttribute("userName");
    	 
        
        //if(userDetails==null) 
        //{
        	
           // return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
       // }
       // else
       // {
        
            ProfilePicture profilePicture=new ProfilePicture();
           
            profilePicture.setLoginName(user1);

            profilePicture.setImage(fileupload.getBytes());
          
            profileUpdateDAO.save(profilePicture);
         //   return new ResponseEntity<Void>(HttpStatus.OK);
      // }
    }
    
    @RequestMapping(value="/getImage/{userName}")
    public @ResponseBody byte[] getProfilePic(@PathVariable("userName") String loginName)
    {
    
        ProfilePicture profilePicture=profileUpdateDAO.getProfilePicture(loginName);
        
        
        if(profilePicture==null)
        {
        	
            return null;
        }
        else
        {
            return profilePicture.getImage();
        }
    }

}
