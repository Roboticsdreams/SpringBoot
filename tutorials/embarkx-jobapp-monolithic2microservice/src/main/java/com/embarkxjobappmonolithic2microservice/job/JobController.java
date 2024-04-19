package com.embarkxjobappmonolithic2microservice.job;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobList = jobService.getAllJobs();
        return new ResponseEntity<>(jobList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job newjob = jobService.createJob(job);
        return new ResponseEntity<>(newjob, HttpStatus.CREATED);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        Job newjob = jobService.getJobById(jobId);
        if (newjob != null) {
            return new ResponseEntity<>(newjob, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(newjob, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Job> updateJob(@PathVariable Long jobId, @RequestBody Job job) {
        Job updatedJob = jobService.updateJob(jobId, job);
        if (updatedJob != null) {
            return new ResponseEntity<>(updatedJob, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(updatedJob, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId) {
        if (jobService.deleteJob(jobId)) {
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
}
