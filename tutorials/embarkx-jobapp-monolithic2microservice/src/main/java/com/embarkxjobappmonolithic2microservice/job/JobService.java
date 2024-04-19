package com.embarkxjobappmonolithic2microservice.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job createJob(Job job);
    Job getJobById(Long jobid);
    Job updateJob(Long jobid, Job updatejob);
    boolean deleteJob(Long jobid);
}
