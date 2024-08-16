package org.kafkaproject.microservice.job.impl;

import org.kafkaproject.microservice.job.Job;
import org.kafkaproject.microservice.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>();
    private long id = 1L;

    @Override
    public List<Job> findAll() {

        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(id++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobs.stream().filter(j -> Objects.equals(j.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        boolean result = jobs.stream().anyMatch(j -> Objects.equals(j.getId(), id));

        if(result) {
            jobs.removeIf(j -> Objects.equals(j.getId(), id));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        boolean result = jobs.stream().anyMatch(j -> Objects.equals(j.getId(), id));

        if (result) {
            Job oldjob = getJobById(id);
            oldjob.setDescription(job.getDescription());
            oldjob.setTitle(job.getTitle());
            oldjob.setMaxSalary(job.getMaxSalary());
            oldjob.setMinSalary(job.getMinSalary());
            oldjob.setLocation(job.getLocation());
        }
        return result;
    }
}
