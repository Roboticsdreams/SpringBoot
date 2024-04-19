package com.embarkxjobappmonolithic2microservice.job.impl;

import com.embarkxjobappmonolithic2microservice.job.Job;
import com.embarkxjobappmonolithic2microservice.job.JobRepository;
import com.embarkxjobappmonolithic2microservice.job.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs () {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob (Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJobById (Long jobid) {
        return jobRepository.findById(jobid).orElse(null);
    }

    @Override
    public Job updateJob (Long jobid, Job updatejob) {
        Job job = getJobById(jobid);
        if (job != null) {
            job.setDescription(updatejob.getDescription());
            job.setTitle(updatejob.getTitle());
            job.setMinsalary(updatejob.getMinsalary());
            job.setMaxsalary(updatejob.getMaxsalary());
            job.setLocation(updatejob.getLocation());
            jobRepository.save(job);
        }
        return job;
    }

    @Override
    public boolean deleteJob (Long jobid) {
        Job job = getJobById(jobid);
        if (job != null) {
            jobRepository.delete(job);
            return true;
        }
        return false;
    }
}
