package com.niit.dao;

import java.util.List;

import com.niit.model.ApplyJob;
import com.niit.model.Job;

public interface JobDAO {
public boolean addJob(Job job);
public boolean deleteJob(Job job);
public boolean updateJob(Job job);
public Job getJob(int jobId);
public List<Job> listJob(int jobId);
public List<Job> listallJob();
public boolean getApplications(int jobId);

public boolean applyJob(ApplyJob job);
public List<ApplyJob> getAllApplicationJobDetails();
}
