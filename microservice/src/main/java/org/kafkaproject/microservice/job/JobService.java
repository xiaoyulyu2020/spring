package org.kafkaproject.microservice.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean updateJob(Long id, Job job);
    boolean deleteJob(Long id);
}
