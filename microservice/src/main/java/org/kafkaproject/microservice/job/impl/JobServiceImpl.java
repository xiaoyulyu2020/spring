package org.kafkaproject.microservice.job.impl;

import org.kafkaproject.microservice.job.Job;
import org.kafkaproject.microservice.job.JobRepo;
import org.kafkaproject.microservice.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {
//    private final List<Job> jobs = new ArrayList<>();

    JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        boolean result = jobRepo.existsById(id);

        if(result) {
            jobRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        boolean result = jobRepo.existsById(id);

        if (result) {
            Job oldjob = getJobById(id);
            oldjob.setDescription(job.getDescription());
            oldjob.setTitle(job.getTitle());
            oldjob.setMaxSalary(job.getMaxSalary());
            oldjob.setMinSalary(job.getMinSalary());
            oldjob.setLocation(job.getLocation());
            jobRepo.save(oldjob);
        }
        return result;
    }
}
