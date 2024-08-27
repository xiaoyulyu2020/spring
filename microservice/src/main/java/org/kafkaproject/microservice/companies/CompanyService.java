package org.kafkaproject.microservice.companies;

import org.kafkaproject.microservice.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompany(Long id);
    Company getCompany(Long id);
    List<Job> getAllJobs(Long id);
    void addJob(Long id, Job job);
}
