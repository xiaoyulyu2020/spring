package org.kafkaproject.microservice.companies.Impl;

import org.kafkaproject.microservice.companies.Company;
import org.kafkaproject.microservice.companies.CompanyRepo;
import org.kafkaproject.microservice.companies.CompanyService;
import org.kafkaproject.microservice.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        boolean result = companyRepo.existsById(id);

        if (result) {
            Company oldCompany = companyRepo.findById(id).get();
            oldCompany.setCompanyAddress(company.getCompanyAddress());
            oldCompany.setCompanyName(company.getCompanyName());
            oldCompany.setJobs(company.getJobs());
            companyRepo.save(oldCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        boolean result = companyRepo.existsById(id);
        if (result) {
            companyRepo.deleteById(id);
        }
        return false;
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public List<Job> getAllJobs(Long id) {
        boolean result = companyRepo.existsById(id);
        if (result) {
            return companyRepo.findById(id).get().getJobs();
        }
        return null;
    }

    @Override
    public void addJob(Long id, Job job) {
        boolean companyExists = companyRepo.existsById(id);
        boolean jobExists = companyRepo.findById(id).get().getJobs().contains(job);
        if (!jobExists && companyExists) {
            companyRepo.findById(id).get().addJob(job);
        }
    }
}
