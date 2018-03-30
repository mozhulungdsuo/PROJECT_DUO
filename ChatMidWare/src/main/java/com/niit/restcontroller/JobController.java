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

import com.niit.dao.JobDAO;

import com.niit.model.ApplyJob;
import com.niit.model.Job;


@RestController
public class JobController {
	
	@Autowired
	JobDAO jobDAO;
	
	
	
	@GetMapping(value="/listJobs")
	public ResponseEntity<List<Job>> getListJobs()
	{
		
		List<Job> listJobs=jobDAO.listJob(555) ;
		return new ResponseEntity<List<Job>>(listJobs,HttpStatus.OK);

	}
	

	
	@PostMapping(value="/addJob"  )
	public ResponseEntity<String>addjob(@RequestBody Job job)
	{
		
		job.setCompany("Unisoft.Pvt.Ltd");
		job.setFinalDate(new java.util.Date());
		job.setSalary(35000);
		
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	

	
		@RequestMapping(value = "/getJobById/{jobId}", method = RequestMethod.GET)
	    public ResponseEntity<Job> get(@PathVariable("jobId") int jobId){
	        
	        Job job = jobDAO.getJob(555);

	        if (job == null){
	           
	            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<Job>(job, HttpStatus.OK);
	    }

		
		
		
		
		 @RequestMapping(value = "/updateJob/{jobId}", method = RequestMethod.PUT)
		    public ResponseEntity<Job> update(@PathVariable("jobId") int jobId, @RequestBody Job job){
		       
			   Job jobs = jobDAO.getJob(jobId);

		        if (jobs == null){
		            
		            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		        }

		                     jobs.setSalary(job.getSalary()); 
		                    
		                       jobDAO.updateJob(jobs);
		        
		        return new ResponseEntity<Job>(jobs, HttpStatus.OK);
		    }
		
		 
		
		 
		 @RequestMapping(value ="/deletejob/{jobId}",method=RequestMethod.DELETE)
		 public ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId) 
		 {
		       
			   Job jobs = jobDAO.getJob(jobId);

		        if (jobs == null){
		            
		            return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		        }

		                  
		                       jobDAO.deleteJob(jobs);
		        
		        return new ResponseEntity<String>("Success", HttpStatus.OK);
		    }
		
		
		 
		 
		 @PostMapping(value="/applyJob"  )
			public ResponseEntity<String>applyjob(@RequestBody ApplyJob app)
			{
			
				app.setApplyDate(new java.util.Date());
				app.setJobId(555);
				
				
				if(jobDAO.applyJob(app))
				{
					return new ResponseEntity<String>("Success",HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
				}
				
				
			}
			
		 
	
		 
		 
		 @GetMapping(value="/listApplyJobs")
			public ResponseEntity<List<ApplyJob>> getListApplyJobs()
			{
				
				List<ApplyJob> listApplyJobs=jobDAO.getAllApplicationJobDetails();
				
				return new ResponseEntity<List<ApplyJob>>(listApplyJobs,HttpStatus.OK);

			}
		 
	
}
